
function insertNewModel()
{
    var proizvodjac = document.getElementById("ModelProiz").value;
    var nazivModela = document.getElementById("ModelField").value;
    var mreza = document.getElementById("ModelMreza").value;
    var dimenzije = document.getElementById("ModelDimenzije").value;
    var tezina = document.getElementById("ModelTezina").value;
    var tastatura = document.getElementById("ModelTastatura").value;
    var baterija = document.getElementById("ModelBaterija").value;
    var kamera = document.getElementById("ModelKamera").value;
    var kameraRez = document.getElementById("ModelKameraRez").value;
    var ekran = document.getElementById("ModelEkran").value;
    var ekranVel = document.getElementById("ModelEkranVel").value;
    var ekranRez = document.getElementById("ModelEkranRez").value;
    var BojeEkrana = document.getElementById("BojeEkrana").value;
    var ram = document.getElementById("ModelRAM").value;
    var intMem = document.getElementById("ModelIntMem").value;
    var ExtMem = document.getElementById("ModelExtMem").value;
    var OS = document.getElementById("ModelOS").value;
    var OSver = document.getElementById("ModelOSver").value;
    var dualsim = document.getElementById("ModelDualSim").value;
    var status = document.getElementById("ModelStatus").value;
    var cena = document.getElementById("ModelCena").value;
    var slika = document.getElementById("ModelUpload").value;
    if(proizvodjac != "none" && nazivModela.length != 0 &&
        mreza != "none" && dimenzije.length != 0 && tezina.length != 0 && tastatura != "none" && baterija != "none" 
        && kamera != "none" && kameraRez != "none" && ekran != "none" && ekranVel != "none" 
        && ekranRez != "none" && BojeEkrana != "none" && ram != "none" && intMem != "none"
        && ExtMem != "none" && OS != "none" && OSver != "none" && dualsim != "none"
        && status != "none" && cena.length != 0 )
    { 
        return true;
    }  
    else
    {
        document.getElementById("actionInfo").innerHTML = "Polja nisu adekvatno popunjena. Proverite da neko niste preskocili.<button onclick='refresh()' align='right' >Refresh</button>";
        return false;
    }
       
};

function refresh() {
    
    document.getElementById("actionInfo").innerHTML = " ";
};

