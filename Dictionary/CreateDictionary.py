import glob
import os
import re

from MorphologicalAnalysis.FsmMorphologicalAnalyzer import FsmMorphologicalAnalyzer
from MorphologicalAnalysis.FsmParseList import FsmParseList

'''''''''''''''''''''''''''''''''''''''''''''''''''
Algo: 
  For review in file:
    For sentence in review:
      For work in sentence: 
        if (MorphologicalAnalysis does not exist)
          writeToFile
'''''''''''''''''''''''''''''''''''''''''''''''''''

def getFilesList():
  fileList = []
  os.chdir(r'D:\OzU Semester 7\CS401\GitHub\Turkish Sentiment Analysis\Split Reviews\Beyazperde.com Reviews\Split Files')
  myFiles = glob.glob('*.txt')
  for file in myFiles: 
    fileList.append(file)
  return fileList

fileList = getFilesList()

fsm = FsmMorphologicalAnalyzer()

cleanMorphSet = set()

currentFile = 0
totalFileWordCount = 0
morphWordCount = 0

for file in fileList: 
  currentFile += 1
  print(f'Current File: {currentFile}')
  with open(file, encoding='utf-8') as review:
      for sentence in review:
          # print(sentence.strip())
          for word in re.findall(r'\w+', sentence):
            totalFileWordCount+=1
            morph = fsm.morphologicalAnalysis(word)
            if(morph.size() == 0):
              morphWordCount += 1
              cleanMorphSet.add(word)   

              # print(word)
            # print(word)
            # if (MorphologicalAnalysis does not exist)
            #   writeToFile
          
file = open('bp_clean_morph_dict.txt', 'w', encoding='utf-8')
print('------------ANALYSIS FINISHED--------------------')
for word in cleanMorphSet:
  file.write(word+'\n')

print(f'Total words count: {totalFileWordCount}')
print(f'Total morphed words count: {morphWordCount}')