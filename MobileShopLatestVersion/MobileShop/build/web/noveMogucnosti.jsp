
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nove mogućnosti</title>
        <link rel="stylesheet" href="css/noveMogucnosti.css" />
    </head>
    <body>
        <jsp:include page="include/topAdmin.jsp" />
        <div class="content">
            <p align="center" id="info-bar"></p>
            <table>
                <caption>Ubacite nove vrednosti</caption>  
                <tr>
                    <td>Baterija</td>
                    <td> <input type="text" id="newBaterija" size="50" placeholder='primer: Litijumska' /> </td>
                    <td><button value='Baterija' onclick="insertItem('newBaterija',this.value)" >Ubaci novu vrstu baterije</button></td>
                </tr>
                <tr>
                    <td>Mreže</td>
                    <td> <input type="text" id="newMreze" size="50" placeholder='primer: 850 Mhz 900 Mhz LTP' /> </td>
                    <td><button value='Mreze' onclick="insertItem('newMreze',this.value)" >Ubaci novu vrednost mreže</button></td>
                </tr>
                <tr>
                    <td>Tastatura</td>
                    <td> <input type="text" id="newTastatura" size="50" placeholder='primer: touchscreen' /> </td>
                    <td><button value='Tastatura' onclick="insertItem('newTastatura',this.value)" >Ubaci novu vrstu tastature</button></td>
                </tr>
                <tr>
                    <td>Ekran</td>
                    <td> <input type="text" id="newEkran" size="50" placeholder='primer: TFT' /> </td>
                    <td><button value='Ekran' onclick="insertItem('newEkran',this.value)" >Ubaci novi tip ekrana</button></td>
                </tr>
                <tr>
                    <td>Dimenzije ekrana</td>
                    <td> <input type="text" id="newDimenzije" size="50" placeholder='primer: 5.8' /> </td>
                    <td><button value='Dimenzije ekrana' onclick="insertItem('newDimenzije',this.value)" >Ubaci nove dimenzije ekrana</button></td>
                </tr>
                <tr>
                    <td>Status</td>
                    <td> <input type="text" id="newStatus" size="50" placeholder='primer: ima na stanju' /> </td>
                    <td><button value='Status' onclick="insertItem('newStatus',this.value)" >Ubaci novi status</button></td>
                </tr>
                <tr>
                    <td>Rezolucija ekrana</td>
                    <td> <input type="text" id="newScRes" size="50" placeholder='primer: 2564x1900' /> </td>
                    <td><button value='Rezolucija ekrana' onclick="insertItem('newScRes',this.value)" >Ubaci novu rezoluciju ekrana</button></td>
                </tr>
                <tr>
                    <td>Kamera</td>
                    <td> <input type="text" id="newKamera" size="50" placeholder='primer: 9.0' /> </td>
                    <td><button value='Kamera' onclick="insertItem('newKamera',this.value)" >Ubaci novi kvalitet kamere</button></td>
                </tr>
                <tr>
                    <td>Rezolucija kamere</td>
                    <td> <input type="text" id="newCamRes" size="50" placeholder='primer: 720x720' /> </td>
                    <td><button value='Rezolucija kamere' onclick="insertItem('newCamRes',this.value)" >Ubaci novu rezoluciju kamere</button></td>
                </tr>
                <tr>
                    <td>Boja ekrana</td>
                    <td> <input type="text" id="newColor" size="50" placeholder='primer: ' /> </td>
                    <td><button value='Boja ekrana' onclick="insertItem('newColor',this.value)" >Ubaci novu vrednost boja</button></td>
                </tr>
                <tr>
                    <td>Operativni sistem</td>
                    <td> <input type="text" id="newOS" size="50" placeholder='primer: Android' /> </td>
                    <td><button value='Operativni sistem' onclick="insertItem('newOS',this.value)" >Ubaci novi OS</button></td>
                </tr>
                <tr>
                    <td>Verzija operativnog sistema</td>
                    <td> <input type="text" id="newVOS" size="50" placeholder='primer: v4.4' /> </td>
                    <td><button value='Verzija operativnog sistema' onclick="insertItem('newVOS',this.value)" >Ubaci novu verziju OS</button></td>
                </tr>
                <tr>
                    <td>RAM memorija</td>
                    <td> <input type="text" id="newRAM" size="50" placeholder='primer: 1024' /> </td>
                    <td><button value='RAM memorija' onclick="insertItem('newRAM',this.value)" >Ubaci novu vrednost za RAM</button></td>
                </tr>
                <tr>
                    <td>Interna memorija</td>
                    <td> <input type="text" id="newIntMem" size="50" placeholder='primer: 8096' /> </td>
                    <td><button value='Interna memorija' onclick="insertItem('newIntMem',this.value)" >Ubaci novu veličinu interne memorije</button></td>
                </tr>
               
            </table>
        </div>
        <script>
           
           function insertItem(inputID,buttonValue) {
               
               var vrednostIzPolje = document.getElementById(inputID).value;
               if(vrednostIzPolje.length == 0)
               {
                   alert("Pažnja. Polje "+buttonValue+" je prazno!");
               }
               else 
               {
                   xmlhttp = new XMLHttpRequest();
                   xmlhttp.onreadystatechange = function()
                   {
                        if(xmlhttp.readyState==4 && xmlhttp.status==200)
                        {
                            document.getElementById("info-bar").innerHTML = xmlhttp.responseText;
                        }
                    };
                    xmlhttp.open("GET","NoviModelServlet?action="+buttonValue+"&&value="+vrednostIzPolje,true);
                    xmlhttp.send();
                    
                    alert(buttonValue+" je ubacena.");
                    document.getElementById(inputID).value = "";
               }
           };
           
           function refresh() {
               document.getElementById("info-bar").innerHTML = "";
           }
           
        </script>   
        
    </body>
</html>
