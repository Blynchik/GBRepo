import requests

nameInp = str(input('Введите имя сенсора:'))
URL = f'http://localhost:8080/sensors/registration'
r = requests.get(url = URL)
sensor = r.json()
Sensors = dict(nameInp = name)

if r.status_code == 400:
    print(f'Ошибка сервера: {r.json()["message"]}')
    print(f'Время ошибки: {r.json()["timestamp"]}')
else:
Sensors['name'] = name
