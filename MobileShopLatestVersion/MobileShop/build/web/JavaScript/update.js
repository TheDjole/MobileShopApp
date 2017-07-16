function showValue(vrednost)
{ 
    var select = document.getElementById("SelectPhone").value;
    if(select != "none")
    {
        xmlhttp = new XMLHttpRequest();
        xmlhttp.onreadystatechange = function()
        {
            if(xmlhttp.readyState==4 && xmlhttp.status==200)
            {
                document.getElementById("showPhone").innerHTML = xmlhttp.responseText;
            }
        };
        xmlhttp.open("GET","updateModelServlet?modelId="+select+"&action="+vrednost,true);
        xmlhttp.send();
    }
    else 
    {
        alert("Niste izabrali model!");
        uncheckAll();
    }
       
};

function uncheckAll()
{
       var elem = document.getElementsByName("updatePhone");
       for(var i = 0;i<elem.length;i++) {
           elem[i].checked = false;
       }
};

function izaberi()
{
    uncheckAll();
    document.getElementById("showPhone").innerHTML = " ";
};

function actionCena(vrednost)
{
   var select = document.getElementById("SelectPhone").value;
   var podatak = document.getElementById("novaCenaPolje").value;
   if(podatak.length == 0) alert("Polje je prazno.");
   else 
   {
        xmlhttp = new XMLHttpRequest();
        xmlhttp.onreadystatechange = function()
        {
            if(xmlhttp.readyState==4 && xmlhttp.status==200)
            {
                document.getElementById("messageBar").innerHTML = xmlhttp.responseText;
            }
        };
        xmlhttp.open("GET","updateModelServlet?modelId="+select+"&action="+vrednost+"&novaCena="+podatak,true);
        xmlhttp.send();
        izaberi();
   }
    
};

function actionDimenzija(vrednost)
{
   var select = document.getElementById("SelectPhone").value;
   var podatak = document.getElementById("novaDimenzijaPolje").value;
   if(podatak.length == 0) alert("Polje je prazno.");
   else
   {
        xmlhttp = new XMLHttpRequest();
        xmlhttp.onreadystatechange = function()
        {
            if(xmlhttp.readyState==4 && xmlhttp.status==200)
            {
                document.getElementById("messageBar").innerHTML = xmlhttp.responseText;
            }
        };
        xmlhttp.open("GET","updateModelServlet?modelId="+select+"&action="+vrednost+"&novaDimenzija="+podatak,true);
        xmlhttp.send();
        izaberi();
   }
    
};

function actionNaziv(vrednost)
{
   var select = document.getElementById("SelectPhone").value;
   var podatak = document.getElementById("noviNazivPolje").value;
   if(podatak.length == 0) alert("Polje je prazno.");
   else 
   {
        xmlhttp = new XMLHttpRequest();
        xmlhttp.onreadystatechange = function()
        {
            if(xmlhttp.readyState==4 && xmlhttp.status==200)
            {
                document.getElementById("messageBar").innerHTML = xmlhttp.responseText;
            }
        };
        xmlhttp.open("GET","updateModelServlet?modelId="+select+"&action="+vrednost+"&noviNaziv="+podatak,true);
        xmlhttp.send();
        izaberi();
   }
    
};

function actionStatus(vrednost)
{
   var select = document.getElementById("SelectPhone").value;
   var podatak = document.getElementById("noviStatusPolje").value;
   if(podatak.length == 0) alert("Polje je prazno.");
   else 
   {
        xmlhttp = new XMLHttpRequest();
        xmlhttp.onreadystatechange = function()
        {
            if(xmlhttp.readyState==4 && xmlhttp.status==200)
            {
                document.getElementById("messageBar").innerHTML = xmlhttp.responseText;
            }
        };
        xmlhttp.open("GET","updateModelServlet?modelId="+select+"&action="+vrednost+"&statusId="+podatak,true);
        xmlhttp.send();
        izaberi();
   }
};

function reloadBar() {
    document.getElementById("messageBar").innerHTML = " ";
};



