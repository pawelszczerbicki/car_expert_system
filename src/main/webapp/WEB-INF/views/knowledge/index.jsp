<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

knowledge database <br/>
-----------------------------CARS-------------------------

<c:forEach items="${cars}" var="car">
    <br/>
    ***************CAR************************** <br/>
    ${car.make}, ${car.model},${car.fuelConsumption}, ${car.maxSpeed},${car.acceleration},${car.horsePower},${car.moment},${car.capacity},
    <c:forEach items="${car.features}" var="feature">
        ${feature},
    </c:forEach>
    <img src="${car.photo}"/>
</c:forEach>
