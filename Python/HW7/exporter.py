def get_list():
    info = []
    with open('C:\\Users\\Blynchik\\Desktop\\GB Education\\Python\\HW7\\base.txt', 'r') as file:
        for line in file:
            info.append(line.split('/'))
    return info

def get_one(surname):
    info = get_list()
    i = 0
    while i < len(info):
        if info[i][1] == surname +' ':
            return info[i]
        else:
            i += 1

