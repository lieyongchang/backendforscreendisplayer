<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Chat</title>
   		<script type="text/javascript" src="/FRDisplayer/resources/js/websocket.js" > </script>
      
    </head>
    <body>

        <table>
            <tr>
                <td colspan="2">
                    <input type="text" id="username" placeholder="Username"/>
                    <button type="button" onclick="connect();" >Connect</button>
                </td>
            </tr>
            <tr>
                <td>
                    <textarea readonly="true" rows="10" cols="80" id="log"></textarea>
                </td>
            </tr>
            <tr>
                <td>
                    <input type="text" size="51" id="msg" placeholder="Message"/>
                    <button type="button" onclick="send();" >Send</button>
                </td>
            </tr>
        </table>
    </body>

</html>
