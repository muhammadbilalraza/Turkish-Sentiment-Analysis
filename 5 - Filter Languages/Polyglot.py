from polyglot.detect import Detector

Turkish = []
English = []

with open('files_in_use\\member_reviews_less_morphological_words.txt', 'r', encoding='utf-8') as file:
  for word in file:
   detector = Detector(word, quiet=True).language.name
   if (detector == "English"):
    English.append(word)
   else: 
     Turkish.append(word)
    

fr = open('english_members.txt', 'w', encoding='utf-8')
for word in English:
  fr.write(word)
fr.close

fr = open('turkish_members.txt', 'w', encoding='utf-8')
for word in Turkish:
  fr.write(word)
fr.close
