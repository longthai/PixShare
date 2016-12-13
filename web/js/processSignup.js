/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function checkFull() {
    
    var xml = new XMLHttpRequest();
    var uid = document.querySelector("#fullname").value;
    
    xml.open("POST", "http://10.114.32.82:8080/PixShare/res/user/login", true);
    xml.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xml.send("fullname=" + uid );
    if (xml.readyState === 4) {
        if(xml.status === 200) {
            var det = eval( "(" +  xml.responseText + ")");
            if (uid.value === det.username ) {
                document.getElementById("full").innerHTML = "Fullname already exists!";                            
            } 
        }
    }
}

function checkFull() {
    
    var xmlh = new XMLHttpRequest();
    var uid = document.querySelector("#nickname").value;
    
    xml.open("POST", "http://10.114.32.82:8080/PixShare/res/user/login", true);
    xml.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xml.send("nickname=" + uid );
    if (xmlh.readyState === 4) {
        if(xmlh.status === 200) {
            var det = eval( "(" +  xml.responseText + ")");
            if (uid.value === det.username ) {
                document.getElementById("nick").innerHTML = "Username already exists!";                            
            } 
        }
    }
}