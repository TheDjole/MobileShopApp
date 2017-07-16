
function searchByUsername(vrednost)
{   
    refreshSelectUser();
    var polje = document.getElementById("txt1").value;
    xmlhttp = new XMLHttpRequest();
    if(polje.length == 0) 
    {
        document.getElementById("displayUsers").innerHTML = "Zapocnite pretragu";
        return;
    }
    xmlhttp.onreadystatechange = function()
    {
        if(xmlhttp.readyState==4 && xmlhttp.status==200)
        {       
            document.getElementById("displayUsers").innerHTML = xmlhttp.responseText;
        }
    };
    
    xmlhttp.open("GET","PretragaKorisnikaServlet?action=search&value="+vrednost,true);
    xmlhttp.send();
    
};

function showUser(id) 
{
    clearField();
    setText();
    xmlhttp = new XMLHttpRequest();
    if(id == "none"){
        document.getElementById("showProfil").innerHTML = "<h2 align='center'>Izaberi korisnika</h2>";
        return;
    }
    xmlhttp.onreadystatechange = function()
    {
        if(xmlhttp.readyState==4 && xmlhttp.status==200)
        {       
            document.getElementById("showProfil").innerHTML = xmlhttp.responseText;
        }
    };
    
    xmlhttp.open("GET","PretragaKorisnikaServlet?action=show&value="+id,true);
    xmlhttp.send();
};

function refreshSelectUser()
{
        var val = "none";
        var mySelect = document.getElementById("userSelect");
        
        for(var i = 0; i< mySelect.length; i++) {
            if(mySelect[i].value == val) {
                mySelect.selectedIndex = i;
            }
           
        }
    
};
    
function clearField()
{
    document.getElementById("txt1").value = "";
};

function setText()
{
    document.getElementById("displayUsers").innerHTML = " ";
};

