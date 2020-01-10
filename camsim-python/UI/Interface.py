from UI.Option import showAvailableOptions


def openUI():

    while True:


        print("Enter 'bye' to kill the program.")
        showAvailableOptions()
        userInput = input("Choose one of the available options.\n")

        if userInput == "bye":
            break
        else:
            pass
