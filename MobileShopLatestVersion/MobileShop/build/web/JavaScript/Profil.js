function loadContent(vrednost)
{
    refreshInfoBar();
    xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function()
    {
        if(xmlhttp.readyState==4 && xmlhttp.status==200)
        {       
            document.getElementById("profil-load").innerHTML = xmlhttp.responseText;
        }
    };
    xmlhttp.open("GET","profilServlet?value="+vrednost,true);
    xmlhttp.send();
};
             
function refreshPassword()
{
                 
    var box1 = document.getElementById("azur-pass1").value;
    var box2 = document.getElementById("azur-pass2").value;
    if(box1 == box2)
    {
        xmlhttp = new XMLHttpRequest();
        xmlhttp.onreadystatechange = function()
        {
            if(xmlhttp.readyState==4 && xmlhttp.status==200)
            {       
                document.getElementById("info-bar").innerHTML = xmlhttp.responseText;
            }
        };
        xmlhttp.open("POST","profilServlet?value=promenaSifre&&novaLozinka="+box1,true);
        xmlhttp.send();
    }
    else 
    {
        alert("Ukucane sifre se ne poklapaju.");
    }
                 
};
             
function refresh() 
{
    var box1 = document.getElementById("azur-ime").value;
    var box2 = document.getElementById("azur-prezime").value;
    var box3 = document.getElementById("azur-email").value;
    var box4 = document.getElementById("azur-adr").value;
    var box5 = document.getElementById("azur-grd").value;
                 
    xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function()
    {
        if(xmlhttp.readyState==4 && xmlhttp.status==200)
        {       
            document.getElementById("info-bar").innerHTML = xmlhttp.responseText;
        }
    };
    
    xmlhttp.open("POST","profilServlet?value=promenaPodataka&&ime="+box1+"&&prezime="+box2+"&&email="+box3+"&&adresa="+box4+"&&grad="+box5,true);
    xmlhttp.send();
};
             
function refreshInfoBar() {
    document.getElementById("info-bar").innerHTML = "";
};
             

