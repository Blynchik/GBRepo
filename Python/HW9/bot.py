import telebot
import random
import time

token = '5872338983:AAHSwV2yY4Vy6ec_BD-3UfCb70LGwBsWcXQ'

bot = telebot.TeleBot(token)

'''Команда старт'''
@bot.message_handler(commands=['start']) 
def welcome(message):
    markup = telebot.types.ReplyKeyboardMarkup(resize_keyboard=True) 
    item1 = telebot.types.KeyboardButton('Предсказание') 
    item2 = telebot.types.KeyboardButton('Случайное число')
    item3 = telebot.types.KeyboardButton('Гороскоп') 

    markup.add(item1, item2, item3) 

    bot.send_message(message.chat.id, 'Добро пожаловать! Выберите пункт:', reply_markup=markup) 

@bot.message_handler(content_types=['text']) 
def text(message):
    print(message.from_user.first_name ,message.text)
    if message.text == 'Привет':
        bot.send_message(message.chat.id, 'Как дела?')
    elif message.text == 'Предсказание':
        bot.send_message(message.chat.id, 'Задай вопрос')
        time.sleep(5)
        bot.send_message(message.chat.id, str(predictions[random.randint(0,len(predictions))]))
    elif message.text == 'Случайное число':
        bot.send_message(message.chat.id, str(random.randint(1,100)))
    elif message.text == 'Гороскоп':
        bot.send_message(message.chat.id, astrology[random.randint(0,len(predictions))])
    else:
        bot.send_message(message.chat.id, 'Я тебя не понимаю')

predictions = ['Даже не думай', 'Тебе повезет', 'Сделай, как велит сердце']
astrology = ['Сегодня вы будете очень деятельны, но вашей энергии хватит ненадолго. Расходуйте ее по возможности более экономно, иначе к вечеру вы будете просто валиться с ног.',
'Пришло время для хорошо продуманных и принципиальных действий. Однако вам не следует полагаться только на себя самое. Прислушайтесь еще к чьему-либо мнению.',
'Сегодня вам предстоит преодолеть весьма основательное препятствие. Избежать его нельзя - судьба.',
'Постарайтесь осмыслить и усвоить те уроки, которые преподали вам ваши же чувства. Особое внимание уделите тем мелочам, на которые, казалось бы, и время-то тратить жалко.',
'Если кто-то не желает действовать по вашим правилам, его не стоит к этому принуждать. Постарайтесь подавить в себе авторитарность, сегодня она может расцвести пышным цветом.',
'Сегодня над вами могут глупо и очень обидно подшутить. Не стоит впадать в ярость, от вас именно этого и ждут. Лучше сделайте вид, что вы ничего не заметили.',
'Спросите себя нужно ли вам то, чего вы столь отчаянно пытаетесь добиться. Ведь добьетесь же.',
'Все, что вы сегодня будете делать или говорить, будет основано на опыте многих поколений политических и культурных деятелей и прочих ораторов. Так что, если у кого возникнут претензии - отсылайте к первоисточникам.',
'Внимательно следите сегодня за глазами своих собеседников. Во-первых, они могут оказаться значительно откровеннее, нежели их хозяин, а во-вторых, попадаются, знаете ли, такие интересные экземпляры...']

bot.polling(none_stop=True)