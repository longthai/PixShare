/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* global full */

function checkName() {
    
    var xml = new XMLHttpRequest();
    var uid = document.querySelector("#nickname").value;
    
    xml.open("POST", "http://10.114.32.82:8080/PixShare/res/user/login", true);
    xml.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xml.send("nickname=" + uid );
    if (xml.readyState === 4) {
        if(xml.status === 200) {
            var det = eval( "(" +  xml.responseText + ")");
            if (uid.value !== det.username ) {
                document.getElementById("name").innerHTML = "User does not exist!";                            
            } 
        }
    }
}

function checkPass() {
    var xml = new XMLHttpRequest();
    var pass = document.querySelector("#password").value;
    xml.open("POST", "http://10.114.32.82:8080/PixShare/res/user/login", true);
    xml.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xml.send("password=" + pass);
    if (xml.readyState === 4) {
        if(xml.status === 200) {
            var de = eval( "(" +  xml.responseText + ")");
            if (pass.value !== de.password ) {
                document.getElementById("pass").innerHTML = "Wrong Password!";                          
            } 
        }
    }
}