
<?php
 
/*
 * Following code will get single product details
 * A product is identified by product id (pid)
 */
 
// array for JSON response
$response = array();
 
// include db connect class
require_once __DIR__ . '/db_connect.php';
 
// connecting to db
$db = new DB_CONNECT();
 //$_GET['bandera'] = $bandera ; 



// check for post data
//if (isset($_GET['id_dispositivo']) && isset($_GET['telefono']) 
//        && isset($_GET['fecha'])&& isset($_GET['cuerpo']) && isset($_GET['estatus']) ) {
// 
   $id_dispositivo = $_GET['id_dispositivo'];
//    $telefono = $_GET['telefono'];
//    $fecha = $_GET['fecha'];
//    $cuerpo = $_GET['cuerpo'];
//    $estatus = $_GET['estatus'];
 if(TRUE){
    // get a product from products table--->SELECT *FROM mensaje WHERE id_dispositivo = $id_dispositivo
    $result = mysql_query("SELECT `bandera` FROM `dispositivos` WHERE 'imei' = '$id_dispositivo'");
 
    if (!empty($result)) {
        // check for empty result
        if (mysql_num_rows($result) > 0) {
 
            $result = mysql_fetch_array($result);
            //$bandera = $result;
          //  $bloqueo = array();
           // $bloqueo["bandera"] = $result["bandera"];
//            $product["telefono"] = $result["telefono"];
//            $product["fecha"] = $result["fecha"];
//            $product["cuerpo"] = $result["cuerpo"];
//            $product["estatus"] = $result["estatus"];
            
            // success
            $response["success"] = 1;
 
            // user node
           // $response["bloqueo"] = array();
            $response["bandera"] = $result["bandera"];
            //array_push($response["bandera"], $result);
            $_GET['bandera'] = $result["bandera"] ; 
 //$_GET['bandera'] = $bloqueo ;             
// echoing JSON response
            echo json_encode($response);
        } else {
            // no product found
            $response["success"] = 0;
            $response["message"] = "No product found";
 
            // echo no users JSON
            echo json_encode($response);
        }
    } else {
        // no product found
        $response["success"] = 0;
        $response["message"] = "No product found";
 
        // echo no users JSON
        echo json_encode($response);
    }
} else {
    // required field is missing
    $response["success"] = 0;
    $response["message"] = "Required field(s) is missing";
 
    // echoing JSON response
    echo json_encode($response);
}
?>