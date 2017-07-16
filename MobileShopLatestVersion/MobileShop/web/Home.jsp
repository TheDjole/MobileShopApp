<%@page import="entity.Stavka"%>
<%@page import="java.util.List"%>
<%@page import="entity.Korisnik"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
   int kolicina = 0;
      
   if(session.getAttribute("korisnik")!= null)
   {     
       Korisnik kor = (Korisnik)session.getAttribute("korisnik");
   }
   
    if(session.getAttribute("cart") != null) {
        List<Stavka> stavkas = (List<Stavka>)session.getAttribute("cart");
        kolicina = stavkas.size();
    }
    
%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Djole's Phones</title>
        <link rel="stylesheet" href="css/home.css" />
        <script src="JavaScript/Home.js"></script>
    </head>
    <body>
        <div class="heared-class-con">
        <div class="header-class">
             
                <h3><img src="slike/logo/phone.png" alt="phone"/> WEB PRODAVNICA MOBILNIH TELEFONA</h3>
                <p style="float:right"></p>
                <ul>
                    <li class="dropdown">
                        <a href="javascript:void(0)" class="dropbtn">Telefoni</a>
                            <div class="dropdown-content">
                                <a href="StranicaControler?proizvodjac=Samsung">Samsung</a>
                                <a href="StranicaControler?proizvodjac=Apple">Apple</a>
                                <a href="StranicaControler?proizvodjac=Nokia">Nokia</a>
                                <a href="StranicaControler?proizvodjac=LG">LG</a>
                                <a href="StranicaControler?proizvodjac=Huawei">Huawei</a>
                                <a href="StranicaControler?proizvodjac=Alcatel">Alcatel</a>
                                <a href="StranicaControler?proizvodjac=HTC">HTC</a>
                                <a href="StranicaControler?proizvodjac=Sony">Sony</a>
                                <a href="StranicaControler?proizvodjac=Microsoft">Microsoft</a>
                                <a href="StranicaControler?proizvodjac=BlackBerry">BlackBerry</a>
                            </div>
                        </li>
                    <li>
                        <a href="pretraga.jsp">Uporedi telefone</a>
                    </li>
                    <li>
                        <a href="pretraga2.jsp">Detaljna pretraga</a>
                    </li>
                    <li class="dropdown">
                        <a href="javascript:void(0)" class="dropbtn">Korisnik</a>
                        <% if(session.getAttribute("korisnik") == null) { %>
                                <div class="dropdown-content">
                                <a href="prijava.jsp">Prijavi se</a>
                                <a href="prijava.jsp">Registruj se</a>
                            </div>
                        <% } else { %>
                        <div class="dropdown-content">
                            <a href="profil.jsp">Moj profil</a>
                            <a href="profil.jsp">Moje porudzbine</a>
                            <a href="logoutServlet?action=logout">Izloguj se</a>
                        </div> <% } %>
                    </li>
                    <li>
                        <a href="cart.jsp">Korpa <%= kolicina %></a>
                    </li>
                </ul>
         </div>
        </div>
        <div class="content">
            <div class="proizvodjaci">
                <a href="StranicaControler?proizvodjac=Samsung"><button value="Samsung">Samsung</button></a><br/>
                <a href="StranicaControler?proizvodjac=Apple"><button value="Apple">Apple</button></a><br/>
                <a href="StranicaControler?proizvodjac=Nokia"><button value="Nokia">Nokia</button></a><br/>
                <a href="StranicaControler?proizvodjac=LG"><button value="LG">LG</button></a><br/>
                <a href="StranicaControler?proizvodjac=Huawei"><button value="Huawei">Huawei</button></a><br/>
                <a href="StranicaControler?proizvodjac=Alcatel"><button value="Alcatel">Alcatel</button></a><br/>
                <a href="StranicaControler?proizvodjac=HTC"><button value="HTC">HTC</button></a><br/>
                <a href="StranicaControler?proizvodjac=Sony"><button value="Sony">Sony</button></a><br/>
                <a href="StranicaControler?proizvodjac=Microsoft"><button value="Microsoft">Microsoft</button></a><br/>
                <a href="StranicaControler?proizvodjac=BlackBerry"><button value="Blackberry">Blackberry</button></a>
            </div>
            <div class="container">
                <ul>
                    <li>
                        <div class="item">
                            <img src="slike/slikeTelefona/galaxy-s6.jpg" alt="GALAXY-S6" />
                            <h4>Samsung galaxy-s6</h4>
                            <p>Cena: 60990,00 RSD</p>
                            <form action="specifikacijaServlet">
                            <button value ="1" name="btn1" class="specifikacije" >Specifikacije</button>
                            <a href="orderServlet?action=order&&id=1"><input type="button" value="Ubaci u korpu" /></a>
                            </form>
                        </div>
                    </li> 
                    <li>
                        <div class="item">
                            <img src="slike/slikeTelefona/samsung-galaxy-a5.jpg" alt="GALAXY-a5" />
                            <h4>Samsung galaxy-a5</h4>
                            <p>Cena: 31155,00 RSD</p>
                            <form action="specifikacijaServlet">
                            <button value ="3" name="btn1" class="specifikacije" >Specifikacije</button>
                            <a href="orderServlet?action=order&&id=3"><input class="ubaci" type="button" value="Ubaci u korpu" /></a>
                            </form>
                        </div>
                    </li>
                    <li>
                        <div class="item">
                            <img src="slike/slikeTelefona/samsung-galaxy-n920.jpg" alt="Note 5 32GB" />
                            <h4>Note 5 32GB</h4>
                            <p>Cena: 59770,00 RSD</p>
                            <form action="specifikacijaServlet">
                            <button value ="4" name="btn1" class="specifikacije" >Specifikacije</button>
                            <a href="orderServlet?action=order&&id=4"><input type="button" value="Ubaci u korpu" /></a>
                            </form>
                        </div>
                    </li>
                    <li>
                        <div class="item">
                            <img src="slike/slikeTelefona/microsoft-lumia-950.jpg" alt="Lumia 950 XL" />
                            <h4>Lumia 950 XL</h4>
                            <p>Cena: 75627,00 RSD</p>
                            <form action="specifikacijaServlet">
                            <button value ="8" name="btn1" class="specifikacije" >Specifikacije</button>
                            <a href="orderServlet?action=order&&id=8"><input type="button" value="Ubaci u korpu" /></a>
                            </form>
                        </div>
                    </li>
                    <li>
                        <div class="item">
                            <img src="slike/slikeTelefona/apple-iphone-6s-32gb.jpg" alt="iphone-6s-32gb" />
                            <h4>iPhone 6s 32GB</h4>
                            <p>Cena: 62820,00 RSD</p>
                            <form action="specifikacijaServlet">
                            <button value ="10" name="btn1" class="specifikacije" >Specifikacije</button>
                            <a href="orderServlet?action=order&&id=10"><input type="button" value="Ubaci u korpu" /></a>
                            </form>
                        </div>
                    </li>
                    <li>
                        <div class="item">
                            <img src="slike/slikeTelefona/apple-iphone-6-1.jpg" alt="iPhone 6 128GB" />
                            <h4>iPhone 6 128GB</h4>
                            <p>Cena: 73188,00 RSD</p>
                            <form action="specifikacijaServlet">
                            <button value ="12" name="btn1" class="specifikacije" >Specifikacije</button>
                            <a href="orderServlet?action=order&&id=12"><input type="button" value="Ubaci u korpu" /></a>
                            </form>
                        </div>
                    </li>
                    <li>
                       <div class="item">
                            <img src="slike/slikeTelefona/apple-iphone-7-128gb-jet-black.jpg" alt="iPhone 7 128GB Jet Black" />
                            <h4>iPhone 7 128GB Jet Black</h4>
                            <p>Cena: 82946,00 RSD</p>
                            <form action="specifikacijaServlet">
                            <button value ="13" name="btn1" class="specifikacije" >Specifikacije</button>
                            <a href="orderServlet?action=order&&id=13"><input type="button" value="Ubaci u korpu" /></a>
                            </form>
                        </div>
                    </li>
                    <li>
                       <div class="item">
                            <img src="slike/slikeTelefona/lg-g4-leather.jpg" alt="lg-g4-leather" />
                            <h4>LG G4 leather</h4>
                            <p>Cena: 40863,00 RSD</p>
                            <form action="specifikacijaServlet">
                            <button value ="21" name="btn1" class="specifikacije" >Specifikacije</button>
                            <a href="orderServlet?action=order&&id=21"><input type="button" value="Ubaci u korpu" /></a>
                            </form>
                        </div>
                    </li>
                    <li>
                       <div class="item">
                            <img src="slike/slikeTelefona/htc-one-m9.jpg" alt="HTC One M9" />
                            <h4>HTC ONE M9</h4>
                            <p>Cena: 68308,00 RSD</p>
                            <form action="specifikacijaServlet">
                            <button value ="32" name="btn1" class="specifikacije" >Specifikacije</button>
                            <a href="orderServlet?action=order&&id=32"><input type="button" value="Ubaci u korpu" /></a>
                            </form>
                        </div>
                    </li>
                    <li>
                       <div class="item">
                            <img src="slike/slikeTelefona/huawei-p10.jpg" alt="Huawei P10" />
                            <h4>Huawei P10</h4>
                            <p>Cena: 59770,00 RSD</p>
                            <form action="specifikacijaServlet">
                            <button value ="42" name="btn1" class="specifikacije" >Specifikacije</button>
                            <a href="orderServlet?action=order&&id=42"><input type="button" value="Ubaci u korpu" /></a>
                            </form>
                        </div>
                    </li>
                    <li>
                       <div class="item">
                            <img src="slike/slikeTelefona/sony-xperia-z5.jpg" alt="sony-xperia-z5" />
                            <h4>Sony Xperia Z5</h4>
                            <p>Cena: 59770,00 RSD</p>
                            <form action="specifikacijaServlet">
                            <button value ="26" name="btn1" class="specifikacije" >Specifikacije</button>
                            <a href="orderServlet?action=order&&id=26"><input type="button" value="Ubaci u korpu" /></a>
                            </form>
                        </div>
                    </li>
                    <li>
                       <div class="item">
                            <img src="slike/slikeTelefona/huawei-mate-s-.jpg" alt="Huawei Mate S" />
                            <h4>Huawei Mate S</h4>
                            <p>Cena: 48792,00 RSD</p>
                            <form action="specifikacijaServlet">
                            <button value ="46" name="btn1" class="specifikacije" >Specifikacije</button>
                            <a href="orderServlet?action=order&&id=46"><input type="button" value="Ubaci u korpu" /></a>
                            </form>
                        </div>
                    </li>
                </ul>
                
            </div>
        </div>
        
    </body>
</html>
