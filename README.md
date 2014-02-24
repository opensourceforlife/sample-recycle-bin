Sample Recycle Bin
==================

With recent Liferay 6.2 release, Recycle Bin has been added for mostly all Out Of the Box asset type. Here I've created Sample Recycle Bin portlet which covers on how we can add this feature for our custom plugins portlet.

Here I've used a simple portlet with CRUD opertion and added Recycle Bin into it. It's maven based project.

Blog
----
Do visit [Recycle Bin for your Custom Portlet in Liferay 6.2](http://www.opensourceforlife.com/2014/02/recycle-bin-for-your-custom-portlet-in.html "Recycle Bin for your Custom Portlet in Liferay 6.2") for complete step by step details on how we can plug Recycle Bin for out Custom Plugins Portlet.

Download
--------
* __Packaged war__   
  Ready to use packaged war can be download from [Release](https://github.com/opensourceforlife/sample-recycle-bin/releases "Release") section. Just download the war and paste it to Liferay's deploy folder.  
  
* __Source__   
Complete Source can be download as zip from [Release History](https://github.com/opensourceforlife/sample-recycle-bin/releases "Release History") OR you can [fork](https://github.com/opensourceforlife/sample-recycle-bin/fork "fork") this Git project



Build Service
-------------
First go to your project root folder and execute. After making any change in service code you need to execute this.

    mvn clean build-service


Build Project
-------------
In order to build project and generate war file. This will also copy generate war to Liferay's deploy folder defined as <liferay.auto.deploy.dir> in pom.xml

    mvn clean package liferay:deploy
    
Contact
-------
For any issue, raise it from [Issues](https://github.com/opensourceforlife/sample-recycle-bin/issues "Issues") as New Issue  
OR  
Reach out at admin{at}opensourceforlife.com for any issue/feedback/help.
