from Button.Button import Button


class Switch(Button):
    name: str
    state: int # 0 OFF 1 ON

    def __init__(self, name: str):
        self.name = name
        self.state = 0  # OFF by default

    # def getname(self):
    #     return self.name

    # def getstate(self):
    #     return self.state

    def switch(self):
        if self.state == 0:
            self.state = 1
        else:
            self.state = 0
