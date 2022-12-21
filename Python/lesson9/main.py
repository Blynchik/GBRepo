import telebot
import random

token = '5872338983:AAHSwV2yY4Vy6ec_BD-3UfCb70LGwBsWcXQ'

bot = telebot.TeleBot(token)

'''Команда старт'''
@bot.message_handler(commands=['start']) #Команда при вводе в чате
def welcome(message):
    markup = telebot.types.ReplyKeyboardMarkup(resize_keyboard=True) #Контейнер для кнопок с их масштабированием
    item1 = telebot.types.KeyboardButton('Случайное число') #кнопка
    item2 = telebot.types.KeyboardButton('Кинуть кость')

    markup.add(item1, item2) #кнопки в контейнере

    bot.send_message(message.chat.id, 'Добро пожаловать! Выберите пункт:', reply_markup=markup) #message еще хранится информация о пользователе

@bot.message_handler(content_types=['text']) #Если пользователь что-то отправил, возрващаем ему
def text(message):
    print(message.from_user.first_name ,message.text)
    if message.text == 'привет':
        bot.send_message(message.chat.id, 'Как дела?')
    elif message.text == 'Случайное число':
        bot.send_message(message.chat.id, str(random.randint(1,10)))
    elif message.text == 'Кинуть кость':
        bot.send_message(message.chat.id, str(random.randint(1,6)))
    else:
        bot.send_message(message.chat.id, 'Я тебя не понимаю')
    
bot.polling(none_stop=True)