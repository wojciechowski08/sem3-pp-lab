from Button.Button import Button


class ShutterButton(Button):
    state:str # 0 not pressed, 1 half press, 2 pressed

    def __init__(self, name: str):
        super().__init__(name)
        self.state = 0


    def getState(self) -> int:
        return self.state

    def setState(self, newState):
        self.state = newState

    def halfpress(self):
        self.state = 1

    def press(self):
        self.state = 2

    def unpress(self):
        self.state = 0


