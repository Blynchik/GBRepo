import telebot
import random

token = '5872338983:AAHSwV2yY4Vy6ec_BD-3UfCb70LGwBsWcXQ'

bot = telebot.TeleBot(token)

'''Команда старт'''
@bot.message_handler(commands=['start']) 
def welcome(message):
    markup = telebot.types.ReplyKeyboardMarkup(resize_keyboard=True) 
    item1 = telebot.types.KeyboardButton('Случайное число') 
    item2 = telebot.types.KeyboardButton('Кинуть кость')
    item3 = telebot.types.KeyboardButton('Угадай число')
    item4 = telebot.types.KeyboardButton('Гороскоп')

    markup.add(item1, item2, item3, item4) 

    bot.send_message(message.chat.id, 'Добро пожаловать! Выберите пункт:', reply_markup=markup) 

@bot.message_handler(content_types=['text']) 
def text(message):
    print(message.from_user.first_name ,message.text)
    if message.text == 'привет':
        bot.send_message(message.chat.id, 'Как дела?')
    elif message.text == 'Случайное число':
        bot.send_message(message.chat.id, str(random.randint(1,10)))
    elif message.text == 'Кинуть кость':
        bot.send_message(message.chat.id, str(random.randint(1,6)))
    elif message.text == 'Угадай число':
        msg = bot.send_message(message.chat.id, 'Введите число')
        bot.register_next_step_handler(msg, game)
    elif message.text == 'Гороскоп':
        markup = telebot.types.InlineKeyboardMarkup(row_width = 3)

        item1 =     telebot.types.InlineKeyboardButton('Овен', callback_data = '1')
        item2 =     telebot.types.InlineKeyboardButton('Телец', callback_data = '2')
        item3 =     telebot.types.InlineKeyboardButton('Близнецы', callback_data = '3')
        item4 =     telebot.types.InlineKeyboardButton('Рак', callback_data = '4')
        item5 =     telebot.types.InlineKeyboardButton('Лев', callback_data = '5')
        item6 =     telebot.types.InlineKeyboardButton('Дева', callback_data = '6')
        item7 =     telebot.types.InlineKeyboardButton('Весы', callback_data = '7')
        item8 =     telebot.types.InlineKeyboardButton('Скорпион', callback_data = '8')
        item9 =     telebot.types.InlineKeyboardButton('Стрелец', callback_data = '9')
        item10 =     telebot.types.InlineKeyboardButton('Козерог', callback_data = '10')
        item11 =    telebot.types.InlineKeyboardButton('Водолей', callback_data = '11')
        item12 =   telebot.types.InlineKeyboardButton('Рыбы', callback_data = '12')

        markup.add(item1, item2, item3, item4, item5, item6, item7, item8, item9, item10, item11, item12 ) 

        bot.send_message(message.chat.id, 'Гороскоп', reply_markup=markup)
    else:
        bot.send_message(message.chat.id, 'Я тебя не понимаю')

def game(message):
    num = random.randint(1,11)
    
    if message.text==str(num):
        bot.send_message(message.chat.id, 'Верно')
    else:
        bot.send_message(message.chat.id, 'Неверно')
        bot.send_sticker(message.chat.id, 'CAACAgIAAxkBAAEHAiNjqWuvrY-MqGfUKA_nvbKaERZllwACiAADR5sLNbwTf7Q2ROTPLAQ')

@bot.callback_query_handler(func=lambda call: True)
def callback_inline(call):
    string = from_file(call.data)
    bot.send_message(call.message.chat.id, string)

def from_file(line):
    string =''
    with open('C:\\Users\\Blynchik\\Desktop\\GB Education\\Python\HW10\\base.txt', 'r', encoding='utf-8') as file:
        for i in range(int(line)):
            string = file.readline()
    return string
    
bot.polling(none_stop=True)
