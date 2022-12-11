
import math

#Задача 1.
orbits = [(1,3), (2.5,10), (7,2), (6,6), (4,3)]

def find_farthest_orbit(list):
    sqr = [math.pi*orbits[i][0]*orbits[i][1] for i in range(0,len(list)) if orbits[i][0] != orbits[i][1]]

    farthest = [(list[i][0], list[i][1]) for i in range(0,len(list)) if math.pi*orbits[i][0]*orbits[i][1] == max(sqr)]
    return farthest  
    

print(*find_farthest_orbit(orbits))

#Задача 2.
values = [1,2,3,4]

def same_by (characteristic, objects):
    row=[characteristic(objects[i]) for i in range(0,len(objects)) if characteristic(objects[0]) == characteristic(objects[i])]

    if len(row)==len(objects):
        return True
    return False

if same_by(lambda x: x % 2, values):
    print('same')
else:
    print('different')

#Задача 3
def print_operation_table(operation, num_rows = 9, num_columns = 9):
    for i in range (1, num_rows+1):
        print()
        print(*[operation(i,j) for j in range (1, num_columns+1)])

print_operation_table(lambda x, y: x*y)




