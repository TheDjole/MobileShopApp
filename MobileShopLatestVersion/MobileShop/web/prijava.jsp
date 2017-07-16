<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Prijavi se</title>
        <link rel="stylesheet" href="css/prijava.css" />
        <script src="JavaScript/prijava.js"></script>
    </head>
    <body>
        <jsp:include page="include/top.jsp" />
        <div class="content">
            <div id="prijava">
                <h3>Postojeći korisnik</h3>
                <p>Za prijavu upišite korisničko ime i lozinku</p>
                    <table>
                        <tr><td>Korisničko ime: </td><td><input type="text" id="inp-korime" required placeholder="korisnicko ime" /></td></tr>
                        <tr><td>Password: </td><td><input type="password" id="inp-pass" required placeholder="password"/></td></tr>
                        <tr><td colspan="2" style="text-align: center;"><input type="submit" value="Uloguj se" onclick="logovanje()" /></td></tr>
                    </table>
                <p id="proveraKorisnika"></p>
            </div>
            <div id="register">
                <h3>Novi korisnik</h3>
                <p>Za registraciju popunite sledeca polja</p>
                    <table>
                        <tr>
                            <td>Ime: <input type="text" id="inp-ime" required placeholder="ime" /></td>
                            <td></td>
                            <td>Prezime: <input type="text" id="inp-prezime" required placeholder="prezime" /></td>
                        </tr>
                        <tr>
                            <td>Korisničko ime: <input type="text" id="inp-un-korime" required placeholder="korisnicko ime" /></td>
                            <td>Lozinka: <input type="password" id="inp-un-pass1" required placeholder="lozinka" /></td>
                            <td>Ponovi lozinku: <input type="password" id="inp-un-pass2" required placeholder="lozinka" /></td>
                        </tr>
                        <tr>
                            <td>Grad: <input type="text" id="inp-grad" required placeholder="korisnicko ime" /></td>
                            <td>Adresa: <input type="text" id="inp-adresa" required placeholder="adresa" /></td>
                            <td>Postanski broj: <input type="text" id="inp-pb" required placeholder="postanski broj" /></td>
                        </tr>
                        <tr>
                            <td>Broj telefona: <input type="text" id="inp-br" required placeholder="broj telefona"></td>
                            <td>E-mail: <input type="text" id="inp-email" required placeholder="email"></td>
                        </tr>
                        <tr>
                            <td><input value="Registruj se" type="submit" onclick="registracija()" /></td>
                        </tr>
                    </table>
                
                <p id="registracijaKorisnika"></p>
            </div>
            
        </div>
    </body>
</html>
