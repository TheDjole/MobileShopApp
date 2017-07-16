function check1(vred)
{
        refresh3();
        refresh2();
        refresh4();
        refreshSelect();
        clearField();
        xmlhttp = new XMLHttpRequest();
        xmlhttp.onreadystatechange = function()
        {
            if(xmlhttp.readyState==4 && xmlhttp.status==200)
            {       
                document.getElementById("prikaz").innerHTML = xmlhttp.responseText;
            }
        };
        xmlhttp.open("GET","detaljnaPretraga?checkbox=check1&&checkedValue="+vred,true);
        xmlhttp.send();
};
    
function check2(vred)
{
        refresh1();
        refresh3();
        refresh4();
        refreshSelect();
        clearField();
        xmlhttp = new XMLHttpRequest();
        xmlhttp.onreadystatechange = function()
        {
            if(xmlhttp.readyState==4 && xmlhttp.status==200)
            {       
                document.getElementById("prikaz").innerHTML = xmlhttp.responseText;
            }
        };
        xmlhttp.open("GET","detaljnaPretraga?checkbox=check2&&checkedValue="+vred,true);
        xmlhttp.send();
};
    
function check3(vred)
{
        refresh1();
        refresh2();
        refresh4();
        refreshSelect();
        clearField();
        xmlhttp = new XMLHttpRequest();
        xmlhttp.onreadystatechange = function()
        {
            if(xmlhttp.readyState==4 && xmlhttp.status==200)
            {       
                document.getElementById("prikaz").innerHTML = xmlhttp.responseText;
            }
        };
        xmlhttp.open("GET","detaljnaPretraga?checkbox=check3&&checkedValue="+vred,true);
        xmlhttp.send();
};
    
function check4(vred)
{
        refresh1();
        refresh2();
        refresh3();
        refreshSelect();
        clearField();
        xmlhttp = new XMLHttpRequest();
        xmlhttp.onreadystatechange = function()
        {
            if(xmlhttp.readyState==4 && xmlhttp.status==200)
            {       
                document.getElementById("prikaz").innerHTML = xmlhttp.responseText;
            }
        };
        xmlhttp.open("GET","detaljnaPretraga?checkbox=check4&&checkedValue="+vred,true);
        xmlhttp.send();
};
    
function select(vred)
{
        refresh1();
        refresh2();
        refresh3();
        refresh4();
        clearField();
        xmlhttp = new XMLHttpRequest();
        xmlhttp.onreadystatechange = function()
        {
            if(xmlhttp.readyState==4 && xmlhttp.status==200)
            {       
                document.getElementById("prikaz").innerHTML = xmlhttp.responseText;
            }
        };
        if(vred != "none") {
        xmlhttp.open("GET","detaljnaPretraga?checkbox=check5&&checkedValue="+vred,true);
        xmlhttp.send();
        }
};
    
function refresh1()
{
       var elem = document.getElementsByName("camera");
       for(var i = 0;i<elem.length;i++) {
           elem[i].checked = false;
       }
};
function refresh2()
{
       var elem = document.getElementsByName("ScreenRez");
       for(var i = 0;i<elem.length;i++) {
           elem[i].checked = false;
       }
};

function refresh3()
{
       var elem = document.getElementsByName("DualSIM");
       for(var i = 0;i<elem.length;i++) {
           elem[i].checked = false;
       }
};
    
function refresh4()
{
       var elem = document.getElementsByName("Screen");
       for(var i = 0;i<elem.length;i++) {
           elem[i].checked = false;
       }
};
    
function refreshSelect()
{
        var val = "none";
        var mySelect = document.getElementById("mySelect");
        
        for(var i = 0; i< mySelect.length; i++) {
            if(mySelect[i].value == val) {
                mySelect.selectedIndex = i;
            }
           
        }
    
};
    
function searchfield(vrednost)
{
        refresh1();
        refresh2();
        refresh3();
        refresh4();
        refreshSelect();
        xmlhttp = new XMLHttpRequest();
        xmlhttp.onreadystatechange = function()
        {
            if(xmlhttp.readyState==4 && xmlhttp.status==200)
            {       
                document.getElementById("prikaz").innerHTML = xmlhttp.responseText;
            }
        };
        xmlhttp.open("GET","detaljnaPretraga?checkbox=check6&&checkedValue="+vrednost,true);
        xmlhttp.send();
};
    
function clearField()
{
        document.getElementById("searchfield").value = "";
};
    
    
    
    

