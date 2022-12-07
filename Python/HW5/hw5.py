import random

#Напишите программу, удаляющую из текста все слова, содержащие "абв".
def task1():
    with open('C:\\Users\\Blynchik\\Desktop\\GB Education\\Python\\HW5\\Text.txt','r+') as file:
        words = []
        for line in file:
            words = list(filter(lambda x: 'а' not in x and 'б' not in x and 'в' not in x, line.split())) 

            file.seek(0)
            file.truncate()

            for i in range(0,len(words)):
                file.write(f' {words[i]}')

# Создайте программу для игры в "Крестики-нолики".
def task2():
    line =' - - -\n| | | |'

    a = input('Для начала игры нажите Enter ')

    if a == "":
        turn = 1
        
        line1 = line
        line2 = line
        line3 = line

        lines = [line1, line2, line3]

        note1=''
        note2=''

        collision = True
        x = askPosition(turn, note1)
        y = askPosition(turn, note2)
        winner = False

        while winner == False:
        
            if turn%2 == 0:
                print('Ваш ход')
                note1 = 'По горизонтали'
                note2 = 'По вертикали'
            else:
                print('Ход компьютера')
                note1 = ''
                note2 = ''

            x = askPosition(turn, note1)
            y = askPosition(turn, note2)
            collision = checkCell(x,y,lines,turn)
                
            while collision == True:
                x = askPosition(turn, note1)
                y = askPosition(turn, note2)
                collision = checkCell(x,y,lines,turn)
        
            lines = drawTable(lines, x, y, turn)
            winner = checkWinner(lines,turn)
            turn += 1
    
def checkCell (x,y,lines,turn):

    if lines[y-1][x*2+6] != " ":
        if turn%2 == 0:
            print('Ячейка занята')
            print('-------------')
        return True
    return False
        

def changeLine(line, x, turn):
    if turn%2 != 0:
        sign = 'X'
    else:
        sign = 'O'
    line = line[:x*2+6] + sign + line[x*2+7:]
    return line

def drawTable(lines, x, y, turn):
    if y == 1:
        lines[0] = changeLine(lines[0],x,turn)
    if y == 2:
        lines[1] =  changeLine(lines[1],x,turn)
    if y == 3:
        lines[2] = changeLine(lines[2],x,turn)

    print(lines[0])
    print(lines[1])
    print(lines[2])
    print(' - - -')

    return lines


def askPosition(turn, note):

    if turn%2 == 0:
        print(note)
        num = int(input('Введите номер ячейки от 1 до 3: '))
    else:
        num = random.randint(1,3)
    return int(num)

def checkWinner(lines,turn):

    if turn%2 != 0:
        sign = 'X'
    else:
        sign = 'O'

    horizonatal = 0
    diagonalRight = 0
    diagonalLeft = 0
    vertical = 0

    for i in range(0,3):

        horizonatal = 0
        vertical = 0

        for j in range(0,3):
            if lines[i][(j+1)*2+6] == sign:
                horizonatal += 1

        if lines[i][(i+1)*2+6] == sign:
            diagonalLeft += 1
        
        if lines[i][(3-i)*2+6] == sign:
            diagonalRight += 1

        for k in range(0,3):
            if lines[k][(i+1)*2+6] == sign:
                vertical += 1
    
        if horizonatal == 3 or vertical == 3 or diagonalLeft == 3 or diagonalRight == 3:
            if sign  == 'X':
                print('Победил компьютер')
            elif sign == 'O':
                print('Вы победили')
            return True
    return False
    
# Реализуйте RLE алгоритм: реализуйте модуль сжатия и восстановления данных.
# Входные и выходные данные хранятся в отдельных текстовых файлах.

def task3():
    compression()
    restore()

def compression():
    with open('C:\\Users\\Blynchik\\Desktop\\GB Education\\Python\\HW5\\origin.txt', 'r') as file:
        stroke = []
        for line in file:
            symbols = list(line)
            count = 1

            for i in range(0,len(symbols)):
                if i+1 != len(symbols):
                    if symbols[i+1] == symbols[i]:
                        count += 1
                    else:
                        stroke.append(''.join([str(count),symbols[i]]))
                        count = 1
                else:
                    stroke.append(''.join([str(count),symbols[i]]))

    with open('C:\\Users\\Blynchik\\Desktop\\GB Education\\Python\\HW5\\compression.txt','r+') as fileToWrite:
        fileToWrite.seek(0)
        fileToWrite.truncate()

        for i in range(0,len(stroke)):
            fileToWrite.write(stroke[i])

def restore():
    with open('C:\\Users\\Blynchik\\Desktop\\GB Education\\Python\\HW5\\compression.txt', 'r') as file:
        stroke = []
        for line in file:
            symbols = list(line)

        for i in range(0,len(symbols)):
            if i+1 == len(symbols):
                break

            if i%2 == 0:
                count = int(symbols[i])
                for j in range(0,count):
                    stroke.append(symbols[i+1])

        with open('C:\\Users\\Blynchik\\Desktop\\GB Education\\Python\\HW5\\restore.txt','r+') as fileToWrite:
            fileToWrite.seek(0)
            fileToWrite.truncate()

            for i in range(0,len(stroke)):
                fileToWrite.write(stroke[i])

            
task3()