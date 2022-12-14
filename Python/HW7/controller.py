import view
import exporter
import importer

def start():
    choice = view.choose_f()

    if choice == '1':
        importer.save(view.input_info())
        view.show_list(exporter.get_list())
        
    elif choice == '2':
        amount = view.choose_amount()

        if amount == '1':
            view.show_one(exporter.get_one(view.input_surname()))
        elif amount == '2':
            view.show_list(exporter.get_list())


