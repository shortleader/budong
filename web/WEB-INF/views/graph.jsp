<%@ page import="com.budong.R" %><%--
  Created by IntelliJ IDEA.
  User: S401-28
  Date: 2018-11-26
  Time: 오전 10:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Graph Test</title>
    <script type="text/javascript">
        window.onload = function () {

            var dataPoints = [];

            var options = {
                animationEnabled: true,
                theme: "light2",
                title: {
                    text: "아파트 년도별 매매가"
                },
                axisX: {
                    valueFormatString: "YYYY"
                },
                axisY: {
                    title: "시세(만원)",
                    includeZero: false,
                    maximum: 1000
                },
                data: [{
                    type: "column",
                    xValueType: "dateTime",
                    xValueFormatString: "YYYY",
                    yValueFormatString: "#,##0won",
                    dataPoints: dataPoints
                }]
            };
            updateData();

            function addData(data) {
                $.each(data, function (key, value) {
                    dataPoints.push(value)
                });

                $("#chartContainer").CanvasJSChart(options);
                /*var chart = new CanvasJS.Chart("chartContainer",options);
                chart.render();*/

                // setTimeout(updateData, 1500);
            }

            function updateData() {
                $.getJSON("http://localhost:8090/test/<%=R.json.GRAPH_MAPPING%>", addData);
            }

        }
    </script>
</head>

<body>
<div id="chartContainer" style="height: 300px; width: 100%;"></div>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="https://canvasjs.com/assets/script/jquery.canvasjs.min.js"></script>
</body>
</html>