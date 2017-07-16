function prikazi(brend,vrednost)
{
    if(vrednost=="none")
    {
        document.getElementById("phone-ispis").innerHTML = "<p align='center' >Izaberi model</p>";
        return;
    }    
    xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function()
    {
        if(xmlhttp.readyState==4 && xmlhttp.status==200)
        {
            document.getElementById("phone-ispis").innerHTML = xmlhttp.responseText;
        }
    };
    xmlhttp.open("GET","prikaziTelefonServ?proizvodjac="+brend+"&&idModela="+vrednost,true);
    xmlhttp.send();
};



