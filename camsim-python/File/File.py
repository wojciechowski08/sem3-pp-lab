import random
import string


class File:
    name: str
    extension: str
    data: str
    time: str
    size: int

    def __init__(self, name, ext, size, time):
        self.name = name
        self.extension = ext
        self.size = size
        self.time = time
        self.data = ''.join(random.choices(string.ascii_uppercase + string.digits, k=10))

    def getName(self) -> str:
        return self.name

    def setName(self, name: str):
        self.name = name

    def getExtension(self) -> str:
        return self.extension

    # def setExtension(self, ext:str):
    #     self.extension = ext

    def getSize(self) -> int:
        return self.size

    def getTime(self) -> str:
        return self.time

    def getData(self) -> str:
        return self.data
