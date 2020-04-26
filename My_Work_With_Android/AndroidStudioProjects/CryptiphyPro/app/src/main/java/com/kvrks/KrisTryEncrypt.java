package com.kvrks;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class KrisTryEncrypt
{
	public char[] Encrypt(char[] key,char[] plainMessage) throws IOException 
	{
		
		String elementsAscii = "173 219 201 54 161 240 32 220 108 9 175 65 202 37 241 69 100 176 164 93 242 112 177 13 94 221 162 243 99 178 124 86 50 72 121 204 222 179 38 76 244 39 166 40 180 205 53 203 245 223 103 163 75 41 107 181 246 91 111 167 224 206 117 182 174 92 247 122 183 225 207 118 33 88 248 63 87 64 115 208 184 249 226 101 165 10 250 34 209 70 185 104 48 227 58 210 251 89 109 172 126 83 228 59 98 60 73 191 252 211 61 49 229 212 113 186 253 67 35 77 230 119 120 254 200 51 187 42 78 231 213 116 62 190 123 84 95 106 188 96 82 195 232 56 105 214 125 255 194 233 71 189 43 79 215 234 44 68 193 196 171 110 102 235 45 192 80 216 199 236 52 237 46 169 85 97 90 74 114 217 170 238 197 47 81 57 36 168 66 55 239 218 198";
		char elements[] = new char[192];
		String arrayOfAscii[] = elementsAscii.split(" ");
		int eleLength=-1;
	KEYLOOP:for(int i=0;i<key.length;i++)
		{
			int j = elements.length-1;
			while(j>=0)
			{
				if(elements[j] == key[i])
					continue KEYLOOP;
				--j;
			}
			elements[++eleLength] = key[i];
			
		}
		ELELOOP:for(int i=0;i<192;i++)
		{
			int j = elements.length-1;
			System.out.println(arrayOfAscii[i]);
			while(j>=0)
			{
				if(elements[j] == (char)(Integer.parseInt(arrayOfAscii[i])))
					continue ELELOOP;
				--j;
			}
			elements[++eleLength] = (char)Integer.parseInt(arrayOfAscii[i]);
			
		}
		for(int i=0;i<plainMessage.length;i++)
		{
			if(String.valueOf(elements).indexOf(plainMessage[i])==-1)
				plainMessage[i] = ' ';
		}
		char elementsMatrix[][] = new char[16][12];
		int k = (int) Math.floor(Math.random() * 192);
		if(k==6) k=k+10;
		int actualK = k;
		for(int i=0;i<16;i++)
		{
			for(int j=0;j<12;j++)
			{
				if(k>191) k=0;
				elementsMatrix[i][j] = elements[k];
				k++;
			}
		}
		Queue<Character> modifiedPlainMessage = new LinkedList<Character>();
		Queue<Character> preCipher = new LinkedList<Character>();
		if(plainMessage.length%2!=0)
		{
			int m=0;
		 for(int i=0;i<plainMessage.length;i++,m++)
		 {
			 if(m==key.length) m=0;
				plainMessage[i] = elements[((String.valueOf(elements).indexOf(plainMessage[i])+String.valueOf(elements).indexOf(key[m])+i)%192)];
			    modifiedPlainMessage.add(plainMessage[i]);
		 }
		 if(m==key.length) m=0;
		 char extra = elements[((String.valueOf(elements).indexOf(' ')+String.valueOf(elements).indexOf(key[m])+plainMessage.length)%192)];
		 modifiedPlainMessage.add(extra);
		}
		else
		{
			 for(int i=0,m=0;i<plainMessage.length;i++,m++)
			 {
				 if(m==key.length) m=0;
				 plainMessage[i] = elements[((String.valueOf(elements).indexOf(plainMessage[i])+String.valueOf(elements).indexOf(key[m])+i)%192)];
				 modifiedPlainMessage.add(plainMessage[i]);
			 }
		}
		
		while(modifiedPlainMessage.size()>1)
		{
			int firstI=-1,firstJ=-1,secondI=-1,secondJ=-1,newFirstI=-1,newFirstJ=-1,newSecondI=-1,newSecondJ=-1;
			char first,second;
			first = modifiedPlainMessage.remove();
			second = modifiedPlainMessage.remove();
	 LOOP0: for(int i=0;i<16;i++)
				for(int j=0;j<12;j++)
				{
					if(firstI>=0&&firstJ>=0&&secondI>=0&&secondJ>=0)
						break LOOP0;
					else 
					{
						if(elementsMatrix[i][j]==first)
						{	
							firstI = i;
							firstJ = j;
						}
						if(elementsMatrix[i][j]==second)
						{
							secondI = i;
							secondJ = j;
						}
					}
				}
			if(firstI == -1)
			{
				LOOP1: for(int i=0;i<16;i++)
					for(int j=0;j<12;j++)
					{
						if(elementsMatrix[i][j] == ' ')
						{
							firstI = i;
							firstJ = j;
							break LOOP1;
						}
					}

			}
			if(secondI == -1)
			{
			LOOP2: for(int i=0;i<16;i++)
					  for(int j=0;j<12;j++)
				   	  {
				 		if(elementsMatrix[i][j] == ' ')
						{
							secondI = i;
							secondJ = j;
							break LOOP2;
						}
					 }
			}
			if(firstI == secondI)
			{
				newFirstI = firstI;
				newFirstJ = (firstJ+2)%12;
				newSecondI = secondI;
				newSecondJ = (secondJ+2)%12;
			}
			else if(firstJ == secondJ)
			{
				newFirstJ = firstJ;
				newFirstI = (firstI+2)%16;
				newSecondJ = secondJ;
				newSecondI = (secondI+2)%16;
			}
			else 
			{
				newFirstI = secondI;
				newFirstJ = firstJ;
				newSecondI = firstI;
				newSecondJ = secondJ;
			}
			preCipher.add(elementsMatrix[newFirstI][newFirstJ]);
			preCipher.add(elementsMatrix[newSecondI][newSecondJ]);
		}
		preCipher.add(elements[actualK]);
		int i=0;
		char cipher[] = new char[preCipher.size()];
		while(preCipher.size()>0)
		{
			cipher[i] = preCipher.remove();
			i++;
		}
		
		return cipher;
	}
}

