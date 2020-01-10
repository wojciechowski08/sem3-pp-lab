from Button.Button import Button


class ShutterButton(Button):
    state:str # not pressed, half press, press, hold

    def __init__(self, name:str):
        name = self.name
