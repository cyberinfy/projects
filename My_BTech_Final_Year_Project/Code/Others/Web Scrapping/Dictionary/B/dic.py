"""
run these two commands before running this program
1) chcp 65001
2) set PYTHONIOENCODING=utf-8"""
import re
import requests
import urllib
from bs4 import BeautifulSoup
def findDef(word):
	url = 'https://en.oxforddictionaries.com/definition/'+word
	data = urllib.request.urlopen(url).read()
	data0 = data.decode("utf-8")
	
	data1 = re.search('Phrases</strong></h3>',data0)
	try:
	 data1 = data0[0:data1.start()]
	except Exception:
	 data1 = data0
	 pass
	result=""
	soup = BeautifulSoup(data1,'html.parser')
	title = soup.find("meta",  property="og:title")
	fetchedWord = soup.find('span',{'class':'hw'})

	try:
	 t = title["content"]
	 index = t.index("|")
	 t = t[:index]
	 print(t)
	 result = "--Word--\n"+t
	except Exception:
	 result = "--Word--\n"+word
	 pass

	
	data2 = soup.find_all('span',{'class':'pos'})
	result=result+"\n--Type--"
	count = 0
	for i in data2:
		try:
			count = count+1
			if count>1:
			 result = result+", "+i.string
			else:
			 result = result+"\n"+i.string
			
		except Exception:
		 result = result+"\n"+"UnKnownKind"
		 pass
	if(count==0):
		return None
	count = 0	
        				
				
	 
	data3 = soup.find_all('span',{'class':'ind'})
	result=result+"\n"+"--Meanings--"
	for i in data3:
		try:
			result = result+"\n"+i.string
		except Exception:
		 result = result+"\n"+"UnKnownKind"
		 pass	
	data4 = soup.find_all('div',{'class':'ex'})
	result=result+"\n"+"--Examples--"
	for i in data4:
		try:
			result = result+"\n"+i.em.string
		except Exception:
		 result = result+"\n"+"UnKnownKind"
		 pass
	return(result)

with open('words.txt','r', encoding='utf-8') as wordsFile:
	for w in wordsFile:
		try:
		 str = findDef(w)
		except Exception as e:
		 print(e)	
		 continue 
		if(str == None):
			continue

		count = str.count("\n")
		if(count>4):
			destinyPath = "Dictionary/dictionary.txt"
			destinyFile = open(destinyPath,'a',encoding='utf-8')
			destinyFile.write(str+"\n")	
			destinyFile.close()