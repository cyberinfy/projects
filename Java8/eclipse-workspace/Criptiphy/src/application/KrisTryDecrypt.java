package application;



import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class KrisTryDecrypt
{
	public static int NELE = 190,IVAL = 19,JVAL = 10;
	public char[] Decrypt(char[] key,char[] cipher) throws IOException 
	{
		
		String elementsAscii = "173 219 201 54 161 10 240 32 220 108 175 65 202 37 241 69 100 176 164 93 242 112 177 94 221 162 243 99 178 124 86 50 72 121 204 222 179 38 76 244 382 166 40 180 205 53 203 245 223 103 163 75 41 107 181 246 91 111 167 224 206 117 182 174 92 247 122 183 225 207 118 33 88 248 63 87 64 115 208 184 249 226 101 165 250 381 209 70 185 104 48 227 58 210 251 89 109 172 126 83 228 59 98 60 73 191 252 211 61 49 229 212 113 186 253 67 35 77 230 119 120 254 200 51 187 42 78 231 213 116 62 190 123 84 95 106 188 96 82 195 232 56 105 214 125 255 194 233 71 189 43 79 215 234 44 68 193 196 171 110 102 235 45 192 80 216 199 236 52 237 46 169 85 97 90 74 114 217 170 238 197 47 81 57 36 168 66 55 239 218 198";
		
		char elements[] = new char[NELE];
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
		ELELOOP:for(int i=0;i<NELE;i++)
		{
			int j = elements.length-1;
			while(j>=0)
			{
				if(elements[j] == (char)Integer.parseInt(arrayOfAscii[i]))
					continue ELELOOP;
				--j;
			}
			elements[++eleLength] = (char)Integer.parseInt(arrayOfAscii[i]);		
		}
		
		int k = String.valueOf(elements).indexOf(cipher[cipher.length-1]);
	
		char elementsMatrix[][] = new char[IVAL][JVAL];
		
		for(int i=0;i<IVAL;i++)
		{
			for(int j=0;j<JVAL;j++)
			{
				if(k>NELE-1) k=0;
				elementsMatrix[i][j] = elements[k];
				k++;
			}
	
		}
		Queue<Character> modifiedCipher = new LinkedList<Character>();
		Queue<Character> prePlainMessage = new LinkedList<Character>();
	
			 for(int i=0;i<cipher.length-1;i++)
			 {
				 if(String.valueOf(elements).indexOf(cipher[i])==-1) continue;
				 modifiedCipher.add(cipher[i]);
			 }
		
		while(modifiedCipher.size()>1)
		{
			int firstI=-1,firstJ=-1,secondI=-1,secondJ=-1,newFirstI=-1,newFirstJ=-1,newSecondI=-1,newSecondJ=-1;
			char first,second;
			first = modifiedCipher.poll();
			second = modifiedCipher.poll();
			
	 LOOP0: for(int i=0;i<IVAL;i++)
				for(int j=0;j<JVAL;j++)
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
				LOOP1: for(int i=0;i<IVAL;i++)
					for(int j=0;j<JVAL;j++)
					{
						if(elementsMatrix[i][j] == ' ')
						{
							firstI = i;
							firstJ = j;
							break LOOP1;
						}
					}

			}
			if(firstI == secondI)
			{
				newFirstI = firstI;
				newFirstJ = (firstJ-2+JVAL)%JVAL;
				newSecondI = secondI;
				newSecondJ = (secondJ-2+JVAL)%JVAL;
			}
			else if(firstJ == secondJ)
			{
				newFirstJ = firstJ;
				newFirstI = (firstI-2+IVAL)%IVAL;
				newSecondJ = secondJ;
				newSecondI = (secondI-2+IVAL)%IVAL;
			}
			else 
			{
				newFirstI = secondI;
				newFirstJ = firstJ;
				newSecondI = firstI;
				newSecondJ = secondJ;
			}
			prePlainMessage.add(elementsMatrix[newFirstI][newFirstJ]);
			prePlainMessage.add(elementsMatrix[newSecondI][newSecondJ]);
		}
		int i=0;
		
		char plainMessage[] = new char[prePlainMessage.size()];
		while(prePlainMessage.size()>0)
		{
			plainMessage[i] = prePlainMessage.remove();
			i++;
		}
		for(int l=0,m=0;l<plainMessage.length;l++,m++)
		{
			if(m==key.length) m=0;
			int n=((String.valueOf(elements).indexOf(plainMessage[l])-String.valueOf(elements).indexOf(key[m])-l+NELE)%NELE);
			while(n<0)
				n+=NELE;
			plainMessage[l] = elements[n];
			
		}
		if(plainMessage[plainMessage.length-1]==' ') 
		{
			char newPlainMessage[] = new char[plainMessage.length-1];
			for(int l=0;l<plainMessage.length-1;l++)
				newPlainMessage[l] = plainMessage[l];
			newPlainMessage=String.valueOf(newPlainMessage).replace("Ž","\"").replace("ž","\'").toCharArray();
			return newPlainMessage;
		}
		plainMessage=String.valueOf(plainMessage).replace("Ž","\"").replace("ž","\'").toCharArray();
		return plainMessage;
	}
}