

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
<style>
.header-class 
{
   background-color: lightblue;
   color:black;
   padding: 1px;
}

.header-class h3 
{
    text-align: left;
    font-family: monospace, cursive;
    padding-left:10px;
}

.header-class img {
    height: 35px;
    width: 100px;
}

.heared-class-con 
{
    top:0px;
    width: 100%;
    position: fixed;
    margin-left: 0px;
}
ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: inherit;
}

li {
    float: left;
    padding-left:10px;
}

li a, .dropbtn {
    display: inline-block;
    color: black;
    text-align: center;
    padding: 5px 10px;
    text-decoration: none;
}

li a:hover, .dropdown:hover .dropbtn {
    background-color: cornflowerblue;
}


li.dropdown {
    display: inline-block;
}

.dropdown-content {
    display: none;
    position: absolute;
    background-color: white;
    min-width: 160px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
    z-index: 1;
    
}

.dropdown-content a {
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
    text-align: left;
}

.dropdown-content a:hover {background-color: #f1f1f1}



.dropdown:hover .dropdown-content {
    display: block;
}
</style>


<div class="heared-class-con">
<div class="header-class">
    <a href="Home.jsp"><h3><img src="slike/logo/phone.png" alt="phone"/></a> WEB PRODAVNICA MOBILNIH TELEFONA</h3>
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
                    </div> 
                <% } %>
        </li>
        <li>
            <a href="cart.jsp">Korpa <%= kolicina %></a>
        </li>
    </ul>
</div>
</div>

