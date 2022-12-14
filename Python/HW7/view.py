def choose_f():
    print('-----')
    return input('Выберите действие:\n1.Сохранить\n2.Получить\n')

def choose_amount():
    print('-----')
    return input('Выберите действие:\n1.Найти\n2.Получить всех\n')

def show_list(list):
    print('-----')
    i = 0
    while i < len(list):
        row = ''.join(list[i])
        print(row, end='')
        i += 1

def input_surname():
    print('-----')
    return input('Введите фамилию:\n')

def show_one(list):
    print('-----')
    i = 0
    row = ''
    if list == None:
        print('Не существует')
    else:
        while i < len(list):
            row += list[i] 
            i += 1
        print('\n' + row)

def input_info():
    print('-----')
    info = ''
    name = input('Введите имя:\n')
    surname = input('Введите фамилию:\n')
    phone_number = input('Введите номер:\n')
    description = input('Добавьте описание:\n')

    info = name + ' /' + surname + ' /' + phone_number + ' /' + description + '\n'

    return info