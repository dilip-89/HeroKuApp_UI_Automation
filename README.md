# HeroKuApp_UI_Automation

Five Modules Have been Automated. The pages are Form AUthentication Page, DropDOwn Page, Checkboxes Page, Mouse hover page and
Forgot Password Page.

#Instructions to Run the UI Automation

Note : You need to have a Good internet speed. SO please check your BroadBand connection and Execute the AUtomation.

1. CLone the project From the GIT Hub Repository. The project repository is,

https://github.com/dilip-89/HeroKuApp_UI_Automation.git
To clone Open Git Bash and enter this command in desired Directory, 
git clone https://github.com/dilip-89/HeroKuApp_UI_Automation.git

2. Please use the JDK 17 version to run this UI Automation.
3. In order to add the JDK 17 to your inteliJ IDE follow the below instruction,

        1. After Clonning the Project, Open the project in InteliJ IDE.
        2. Now Goto File->Project STructure->project->Add the SDK(JDK 17) and select the Language as 17 Sealed types
            always stict to Floating point Sematics and click Apply.
        3. Now Goto File->Project STructure->Modules->Select the Language Level as 17 Sealed types
            always stict to Floating point Sematics for the project HeroKuApp_UI_AUtomation.
        4. Now Goto File->Project STructure->Plaform Settings->Under SDKs, CHeck whether JDK 17 is added and click on Apply.
        5. Now Goto File->Settings->Build, Execution, Deployment->Compiler->Java Compiler-> Under Pre-module Byte COde version,
            for your clone project the Target byte code version should be 17 make it as 17.
        6. CLick on Apply button and after that click Ok Button.

4. Please Sync the Maven Dependencies From the Maven Repository, To Do that inteliJ IDE on the right hand side top Border 
   you will see the Maven Tab, CLick on that and check whether your CLonned project is selected and click the Reload All 
   Maven Projects. Then YOu will see in the bottom of the INtelij IDE, the Depencies are getting downloaded.

5. Now in InteliJ IDE in your Project Folder, You can see a file named as HeroKuTestNG.xml. Open that File in a new tab in InteliJ
    IDE. Right click on the middle of the HeroKuTestNG.xml page and click on Run'...\HeroKuTestNG.xml'.

6. Then You can see the AUtomation is running on the UI.

# Instruction To Generate the Test Report

1. I have Integrated the Extent Report in the frame work once after Script is completed running You can see the Test Report in
    FOllowing FIle Path.

        "Your clonned project folder Path/test-output/reports/HeroKuApp Regression Report.html"

Note : The Final Test Scenario which is in the ForgotPasswordTest has a issue in verification message. The Alert message is not 
         displaying in the UI, it has not been developed.It is a bug, the UI will wait for 15 seconds. Please wait till that time,
         Once the 15 seconds are over, the browser will automatically close which is the driver.quit().

Note : Wait till the browser closes and the Execution is completed. Then only it will generate the Report.


         Thank you
