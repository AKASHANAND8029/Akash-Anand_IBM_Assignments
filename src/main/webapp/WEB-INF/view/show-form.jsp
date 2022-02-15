<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>show-form</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<form class="row g-3" action="processForm" method="post">
 <div class="mb-3">
         <label for="t1" class="form-label">League Name</label>
         <input type="text" id="t1" class="form-control" name="lName" size="255" maxlength="255">
     </div>
     <div class="mb-3">
         <label for="t2" class="form-label">League Year</label>
         <input type="text"  id="t2" class="form-control" name="lYear" size="4" maxlength="4">
     </div>
     <div class="mb-3">
         <label class="form-label" for="t3">Season</label>
         <select name="lSeason" id="t3">
             <option value="Unknown">Select...</option>
             <option value="Winter">Winter</option>
             <option value="Autumn">Autumn</option>
             <option value="Summer">Summer</option>
         </select>
     </div>
     <button type="submit" class="btn btn-primary">Submit</button>
</form>
</body>
</html>

