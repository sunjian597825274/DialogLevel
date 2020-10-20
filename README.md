# DialogLevel
一 项目详情

该项目是android 管理dialog弹窗

包括功能：

1.设置dialog等级，等级越高，弹窗在上面显示

2.延时显示dialog

二 调用方式

1.每个activity中调用,再需要的activity中添加

 SimpleDialogManager dialogLevelManager = new SimpleDialogManager(MainActivity.this);
 
 dialogLevelManager.showDelay(level,2000,dialog,MainActivity.this);
 
2.在一个进程中调用，比上面的使用方便些

 DialogManager.showDelay(level,3200,dialog,MainActivity.this,MainActivity.this);
 
