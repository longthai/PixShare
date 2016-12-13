PixShare README
===============

This is the README file for the PixShare. PixShare is a web sharing media application, 
developed by the D team: Long Thai, Tien Le and Nam Anh.

What should I do to setup PixShare to a fresh server?
-----------------------------------------------------

If you want to setup PixShare on your server, you need to have:
- A Glassfish server.
- MySQL database that fit with PixShare.
- PixShare.war file.

There are 3 different ways to setup PixShare:
- Using NetBean IDE: if you have the project included all files and items, 
you can easily setup PixShare by running it in NetBean.You can download 
project from here: https://www.dropbox.com/home?preview=PixShare.rar
- Using WinSCP: you can use also WinSCP to setup PixShare by copying the war 
file to this location on your server: /home/glassfish/glassfish4/glassfish/domains/domain1/autodeploy
- Using PuTTy: afterlogging to the root@yourserveripaddress, you must change the onwer of the application: chown glassfish.glassfish yourapp.war, and them move it to the autodeploy folder in your server: 
mv yourapp.war /home/glassfish/glassfish4/glassfish/domains/domain1/autodeploy/

What do I do if it doesn't work?
--------------------------------

Sometimes, NetBean cannot deploy the application to the server due to the size of pictures, size of file, etc.. 
All you need to do is using the other ways, by PuTTy or WinSCP, it will work probably without any problems.

How can I contact you?
----------------------

If you want to contact us, please send an e-mail to one of the 3 addresses below:
tienle@metropolia.fi
anhng@metropolia.fi
longthai@metropolia.fi