﻿#Java课设

##制作旧版画图板


2019.8.11修改（孟）
当前项目完成了基本的组件以及界面的放置，界面还有些丑。
等待实现的有：canvas的所有功能，所有组件对应的监听器的功能，
复制粘贴撤销等等逻辑层功能，以及点击事件发生后弹出的额外窗口的界面绘制及逻辑功能实现。


2019.8.14修改（孟）
实现了按钮栏、字体栏、颜色栏的监听器功能，实现了取色板（点击编辑颜色响应）。
替换了canvas类的使用，经测试，awt.canvas与swing.component组件不相容。
canvas放置到JScrollPane组件中出现画布溢出的情况，故改使用重写的JLabel组件。
等待实现的有：绘图区JLabel的功能，菜单栏的所有功能。
以及复制粘贴撤销等等逻辑层功能。