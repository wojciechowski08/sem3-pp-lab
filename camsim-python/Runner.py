import errno
import os

from Process.OBJECTS import initiate
from UI.Interface import openUI


def run():

#     if not os.path.exists(os.path.dirname('C:/workspace/sem3-pp-LAB/camsim-python/Settings/current-settings.txt')):
#         try:
#             os.makedirs(os.path.dirname('C:/workspace/sem3-pp-LAB/camsim-python/Settings/current-settings.txt'))
#             os.make
#         except OSError as exc:
#             if exc.errno != errno.EEXIST:
#                 raise
#
#     cs = open('current-settings.txt', 'r+')
#
#     # writing
#     params = []
#     data = []
#     for i in range(len(params)):
#         data.append(None)
#     cs.write(data)
#
#
#     print(str(cs.name))
#     cs.close
#
# run()
    initiate()
    openUI()

run()

#mode
#iso
#apreture

#focusing mode
#shooting mode
