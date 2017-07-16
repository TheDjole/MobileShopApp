function prikaziTelefon1(vrednost)
{
    if(vrednost=="none")
    {
        document.getElementById("prikazTelefona1").innerHTML = "Izaberite model";
        return;
    }    
    xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function()
    {
        if(xmlhttp.readyState==4 && xmlhttp.status==200)
        {
            document.getElementById("prikazTelefona1").innerHTML = xmlhttp.responseText;
        }
    };
    xmlhttp.open("GET","uporedjivanjeServlet?prikaz=telefon1&&izabranTelefon="+vrednost,true);
    xmlhttp.send();
};
            
function prikaziTelefon2(vrednost)
{
    if(vrednost=="none")
    {
        document.getElementById("prikazTelefona2").innerHTML = "Izaberite model";
        return;
    }    
    xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function()
    {
        if(xmlhttp.readyState==4 && xmlhttp.status==200)
        {
            document.getElementById("prikazTelefona2").innerHTML = xmlhttp.responseText;
        }
    };
    xmlhttp.open("GET","uporedjivanjeServlet?prikaz=telefon2&&izabranTelefon2="+vrednost,true);
    xmlhttp.send();
};



