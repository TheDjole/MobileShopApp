
function logovanje()
{
    var korIme = document.getElementById("inp-korime").value;
    var pass = document.getElementById("inp-pass").value;
    if(korIme.length == 0 || pass.length == 0)
    {
        document.getElementById("proveraKorisnika").innerHTML = "";
        return;
    }    
    xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function()
    {
        
        if(xmlhttp.readyState==4 && xmlhttp.status==200)
        {
            if(xmlhttp.responseText == "dobrodosliAdmin") 
            {
                window.location = "adminpage.jsp";
            }
            if(xmlhttp.responseText == "dobrodosli") 
            {
                window.location = "Home.jsp";
            }
            else
            {
               document.getElementById("proveraKorisnika").innerHTML = xmlhttp.responseText; 
            }
            
        }
    };
    xmlhttp.open("GET","logServlet?status=1&&korIme="+korIme+"&&lozinka="+pass,false);
    xmlhttp.send();
    
    
}

function registracija()
{
    var ime = document.getElementById("inp-ime").value;
    var prezime = document.getElementById("inp-prezime").value;
    
    var korIme = document.getElementById("inp-un-korime").value;
    var pass1 = document.getElementById("inp-un-pass1").value;
    var pass2 = document.getElementById("inp-un-pass2").value;
    
    var grad = document.getElementById("inp-grad").value;
    var adresa = document.getElementById("inp-adresa").value;
    var pBroj = document.getElementById("inp-pb").value;
    var bTelefona = document.getElementById("inp-br").value;
    var eMail = document.getElementById("inp-email").value;
       
    if(pass1 == pass2)
    {
        xmlhttp = new XMLHttpRequest();
        xmlhttp.onreadystatechange = function()
        {
            if(xmlhttp.readyState==4 && xmlhttp.status==200)
            {
                document.getElementById("registracijaKorisnika").innerHTML = xmlhttp.responseText;
            }
        };
        xmlhttp.open("GET","logServlet?status=2&&ime="+ime+"&&prezime="+prezime+"&&korIme="+korIme+"&&lozinka="+pass1+"&&grad="+grad+"&&adresa="+adresa+"&&postanskiBroj="+pBroj+"&&brojTel="+bTelefona+"&&email="+eMail,false);
        xmlhttp.send();
    }
    else {
        alert("Lozinka se ne poklapa");
        document.getElementById("inp-un-pass1").focus();
        
    }
    
    
    
    
}

