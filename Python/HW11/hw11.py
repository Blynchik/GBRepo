
class MinMaxWordFinder:
    stroke = str()

    def add_sentence(self, stroke):
        self.stroke = self.stroke + ' ' + stroke

    def shortest_words(self):
        amount = int(len(self.stroke.split())/2-1)
        return sorted(sorted(self.stroke.split(), key=len)[:amount])

    def longest_words(self):
        amount = int(len(self.stroke.split())) - int(len(self.stroke.split())/2-1)
        return sorted(sorted(self.stroke.split(), key=len)[:-amount:-1])

finder = MinMaxWordFinder()
finder.add_sentence('hello abc world')
finder.add_sentence('def asdf qwert')
print(' '.join(finder.shortest_words()))
print(' '.join(finder.longest_words()))
        

