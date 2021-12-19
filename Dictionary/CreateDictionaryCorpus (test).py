import glob
import os
from Corpus.Corpus import Corpus
from MorphologicalAnalysis.FsmMorphologicalAnalyzer import FsmMorphologicalAnalyzer


def getFilesList():
  fileList = []
  os.chdir(r'D:\OzU Semester 7\CS401\GitHub\Split dataset sample\Member Reviews (split)')
  myFiles = glob.glob('*.txt')
  for file in myFiles: 
    fileList.append(file)
  return fileList

filesList = getFilesList()

temp = ['1.txt']

fileCount = 0
sentenceCount = 0
wordCount = 0
for file in temp:
  fileCount += 1
  sc = Corpus(file).sentenceCount()
  corpus = Corpus(file).getAllWordsAsList()
  for sentence in corpus:
    sentenceCount += 1
    for words in sentence:
      wordCount += 1
      print(words)
 
  
# to use
# FsmMorphologicalAnalyzer.morphologicalAnalysis()


# print(f'Files length: {len(filesList)}')
print(f'Files count: {fileCount}')
print(f'Corpus length: {len(corpus)}') 
print(f'Corpus Sentence Count: {sc}') 
print(f'Sentence length: {sentenceCount}')
print(f'Words length: {wordCount}')