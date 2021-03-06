from Button.Button import Button


class Dial(Button):
    name: str
    state: int

    def __init__(self, name: str):
        self.name = name
        self.state = 0

    # def getName(self):
    #     return self.name

    # def getState(self):
    #     return self.state

    # def reset(self):
    #     self.state = 0

    def trigger(self, rotation: int):
        self.state += rotation
