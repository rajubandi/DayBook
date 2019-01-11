<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html lang="en">
<head>

<!-- Begin Inspectlet Embed Code -->
<script type="text/javascript" id="inspectletjs">
window.__insp = window.__insp || [];
__insp.push(['wid', 26443257]);
(function() {
function ldinsp(){if(typeof window.__inspld != "undefined") return; window.__inspld = 1; var insp = document.createElement('script'); insp.type = 'text/javascript'; insp.async = true; insp.id = "inspsync"; insp.src = ('https:' == document.location.protocol ? 'https' : 'http') + '://cdn.inspectlet.com/inspectlet.js'; var x = document.getElementsByTagName('script')[0]; x.parentNode.insertBefore(insp, x); };
setTimeout(ldinsp, 500); document.readyState != "complete" ? (window.attachEvent ? window.attachEvent('onload', ldinsp) : window.addEventListener('load', ldinsp, false)) : ldinsp();
})();
</script>
<!-- End Inspectlet Embed Code -->


<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Aurospaces</title>
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/main.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<link rel="stylesheet" href="https://fortawesome.github.io/Font-Awesome/assets/font-awesome/css/font-awesome.css">
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <link rel="shortcut icon" href="images/ico/favicon.ico">
</head>
<body>
 <div class="mainheaderbg"> <div class="header no-marg">
  <div class="container-main">
    <div class="logo"> <a href="./"> <img src="nbdimages/images/logo.png" width="76" height="75" alt="logo image" />
    <div class="name">
        <h3 style="color:#000">Aurospaces</h3>
        <div class="clearfix"></div>
        <p style="color:#000">One space for all services</p>
    </div>
       </a>
    </div>
      <div class="active item text-center ">
              <a href="https://play.google.com/store/apps/details?id=com.aurospace.customer&hl=en" target="_blank">  <img src="nbdimages/Home/mobile11.png" width="1367" height="1647"  class="img-responsive visible-xs clearfix full-width" alt="mobile banner image"></a>
      </div>
      <div class="googleplayimg hidden-xs">
      <a href="https://play.google.com/store/apps/details?id=com.aurospace.customer&hl=en" target="_blank"><img src="nbdimages/Home/googleplay_1.png" width="165" height="56" alt="googleplay image" style="margin-top: 37px;"/></a>
      </div>
      <div style="margin-top: 224px;" class="whatsapp hidden-xs">
      <img src="nbdimages/Home/whatsapp.png" width="165" height="56" alt="whatsapp image"/>
      </div>
       <div class="googleplayimg1 hidden-xs">
      <a href="http://community.aurospaces.com" target="_blank"> <img src="nbdimages/Home/auro community.png" width="165" height="49" alt="faster capital.png image" style="margin-top: -272px;margin-left: 251px;"></a>
      </div>
     
  </div>
</div>
<div class="clearfix"></div>
<!-- div class="banner-main-slider">
  <div class="col-md-12 no-pad">
    <div class="container-fluid carousel-main no-pad">
      <div class="row no-marg">
        <div class="col-md-12 no-pad">
          <div class="carousel slide" id="fade-quote-carousel" data-ride="carousel" data-interval="3000">
            <ol class="carousel-indicators">
              <li data-target="#fade-quote-carousel" data-slide-to="0" class="active"></li>
              <li data-target="#fade-quote-carousel" data-slide-to="1"></li>
              <li data-target="#fade-quote-carousel" data-slide-to="2"></li>
              <li data-target="#fade-quote-carousel" data-slide-to="3"></li>
            </ol>
            
            <div class="carousel-inner banner-main">
            <div class="sliderlogo"> <a href="./"> <img src="nbdimages/images/logo.png" width="70" height="63" alt="logo image" /></div>
              <div class="active item text-center ">
             
               <!-- <a href="https://play.google.com/store/apps/details?id=com.localoye.mobileapp&hl=en"> --><!-- img src="nbdimages/Home/Home_2.png "width="100%" height="393" class="img-responsive banner-main hidden-xs" alt="banner image" align="middle"><!-- </a> -->
                <!-- img src="nbdimages/mobile/mobile_doctor.jpg" width="489" height="589"  class="img-responsive visible-xs clearfix full-width" alt="mobile banner image">
                </div>
              <!-- <div class="item"> <img src="nbdimages/Home/plumber.jpg"  width="2000" height="768"class="img-responsive hidden-xs" alt="banner image">
                <img src="nbdimages/mobile/mobile_plumber.jpg" width="489" height="589"  class="img-responsive visible-xs clearfix full-width" alt="mobile  banner image">
                </div>
              <div class="item"> <img src="nbdimages/Home/pathology.jpg" width="2000" height="768" class="img-responsive hidden-xs" alt="banner image">
                <img src="nbdimages/mobile/mobile_pathology.jpg" width="489" height="589" class="img-responsive visible-xs clearfix full-width" alt="mobile banner image">
                </div>
              <div class="item"> <img src="nbdimages/Home/electrician.jpg" width="2000" height="768" class="img-responsive hidden-xs" alt="banner image"> 
                <img src="nbdimages/mobile/mobile_electrician.jpg" width="489" height="589" class="img-responsive visible-xs clearfix full-width" alt="mobile banner image">
                </div> -->
            <!-- /div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div--> 
</div>
<div class="clearfix"></div>
<section class="SelectLocation"> <!--/. #location & service select-->
  <nav class="navbar navbar-inverse" role="banner">
    <form id="addForm" class="form-horizontal" action="orderTemplate.htm" method="get">
      <input id="serviceId" name="serviceId" type="hidden" value="">
      <input id="loc_id" name='locationId' type="hidden" value="${defaultLocation.id}" >
     <input id="loc_name" type="hidden" value="${defaultLocation.name}">
      <div class="container">
        <div class="col-sm-4">
          <div class="panel-body">
            <div class="btn-group btn-input clearfix">
              <button id="locationBtn" type="button" class="btn btn-default dropdown-toggle form-control selectpicker as-custom-dropdown" data-toggle="dropdown"> <span data-bind="label">Choose location</span>&nbsp; </button>
              <ul class="dropdown-menu auro-location" role="menu" id="chooseLocation">
               <c:forEach var="location" items="${location}">
									    <c:choose>
									    <c:when test="${location.isBold eq '1' }">
												<li class="disli"><a style="font-size:110%" id="${location.id}" ><b>${location.name}</b></a></li>
										</c:when>
										<c:otherwise>
										<c:choose>
										<c:when test="${location.isDummy eq '1'  }">
											 <li class="disli"><a  id="${location.id}" >${location.name}</a></li>
										</c:when>
										<c:otherwise>
												<li><a id="${location.id}" name="${location.name}" href="#" onclick="serviceFilter(this.id , this.name);">${location.name}</a></li>
										  </c:otherwise>
										  </c:choose>
										</c:otherwise>
										</c:choose>
			  </c:forEach>
              </ul>
            </div>
          </div>
        </div>
        
        <div class="col-sm-4">
          <div class="panel-body">
            <div class="btn-group btn-input clearfix">
              <button id="serviceBtn" type="button" class="btn btn-default dropdown-toggle form-control selectpicker as-custom-dropdown" data-toggle="dropdown"> <span data-bind="label">Choose Service</span>&nbsp; </button>
              <ul class="dropdown-menu auro-disease" role="menu" aria-labelledby="dropdownMenu3" id="chooseService">
	<c:forEach var="service" items="${servces}">
		<c:choose>
		<c:when test="${service.isBold eq '1'}">
			<li class="disli"><a style="font-size:110%" style="font-size:100%" id="${service.id}" ><b>${service.name}</b></a></li>
		</c:when>
		<c:otherwise>
			<c:choose>
				<c:when test="${service.isDummy eq '1'}">
				<li class="disli"><a id="${service.id}" >${service.name}</a></li>
				</c:when>
				<c:otherwise>
					<li><a id="${service.id}"  name="${service.name}"  onclick="formOperation(this.id,this.name);">${service.name}</a></li>
			</c:otherwise>
		</c:choose>
		</c:otherwise>
		</c:choose>
	</c:forEach>
              </ul>
            </div>
          </div>
        </div>
        <div class="col-sm-4">
          <div class="panel-body">
            <div class="btn-group btn-input clearfix">
              <div class="cta-inner"> 
                <button type="button" onclick="booking()" class="btn btn-primary btn-lg  as-cutom-but" style="color:#f5d328;font-family:'open-sans',sans-serif;">Book Now  
                </button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </form>
  </nav>
</section>
<div class="clearfix"></div>
<!-- <section>
  <div class="container services">
    <div class="col-md-4 col-sm-4 text-center"> <img src="nbdimages/images/patented2.png"  width="200" height="200" alt="image" class="img-responsive" > </div>
    <div class="clearfix visible-xs">&nbsp;</div>
    <div class="col-md-8 col-sm-8 services-right">
      <h3>Quick Service Guaranteed</h3>
      <p>We are aggregating best field experts for you by our Patented Technology 
        that helps match your needs and serve in your location and at your time.</p>
    </div>
  </div>
</section> -->
<!-- 
<section class="service-list">
  <div class="container">
    <div class="col-md-10 col-sm-10 col-md-offset-1 col-sm-offset-1">
      <h3>You are in Safe Hands <br>
        Book a Service,Relax and Enjoy.</h3>
    </div>
    <div class="clearfix">&nbsp;</div>
    <div class="clearfix">&nbsp;</div>
    <div class="col-md-12">
      <div class="col-md-2 col-sm-3 col-xs-3 text-right no-pad"> <img class="img-responsive center-block" src="nbdimages/homepage/secure-1.jpg" width="152" height="145" style="margin-bottom:5px;float:right" > </div>
      <div class="col-md-7 col-sm-9 col-xs-9">
        <h2 style="color:white;">Background Verification</h2>
        <p class="lead">100% due diligence including police verification</p>
      </div>
    </div>
    <div class="clearfix visible-sm visible-xs">&nbsp;</div>
    <div class="col-md-12">
      <div class="col-md-2 col-sm-3 col-xs-3 text-right no-pad"> <img class="img-responsive center-block" src="nbdimages/homepage/certified-1.jpg" width="152" height="145" style="margin-bottom:5px;float:right" > </div>
      <div class="col-md-7 col-sm-9 col-xs-9">
        <h2 style="color:white;">Certified &amp; Licensed</h2>
        <p class="lead">Our experts meet Industry Best Practises &amp; have <br>
          valid Licenses to serve you.</p>
      </div>
    </div>
    <div class="clearfix visible-sm visible-xs">&nbsp;</div>
    <div class="col-md-12">
      <div class="col-md-2 col-sm-3 col-xs-3 text-right no-pad sai-image"> <img class="img-responsive center-block" src="nbdimages/homepage/skill-level.jpg" width="152" height="145"  style="margin-bottom:5px;float:right" ></div>
      <div class="col-md-7 col-sm-9 col-xs-9">
        <h2 style="color:white;">Field Experience</h2>
        <p class="lead">The average work experience of Auro experts are <br>
          at least 6 years and as high as 30 years.</p>
      </div>
    </div>
  </div>
</section>
<section class="booking">
  <div class="container">
    <h3>Booking is as-easy-as 1-2-3-4</h3>
    <div class="clearfix">&nbsp;</div>
    <div class="clearfix hidden-xs">&nbsp;</div>
    <div class="clearfix hidden-xs">&nbsp;</div>
    <div class="clearfix hidden-xs">&nbsp;</div>
    <div class="row no-mar wizardsteps">
      <div class="stepwizard-row">
        <div class="stripebar"></div>
        <div class="col-md-3 col-sm-3 col-xs-3 stage">
          <div class="list">1</div>
          <p>Choose a Service and Location</p>
        </div>
        <div class="col-md-3 col-sm-3 col-xs-3 stage">
          <div class="list active">2</div>
          <p>Book the Service</p>
        </div>
        <div class="col-md-3 col-sm-3 col-xs-3 stage">
          <div class="list">3</div>
          <p>Get the best matched Auro Professional</p>
        </div>
        <div class="col-md-3 col-sm-3 col-xs-3 stage">
          <div class="list ">4</div>
          <p>Relax, Enjoy &amp; Track</p>
        </div>
      </div>
    </div>
    end of progress bar 
  </div>
</section>
 -->

<!-- <section class="booking1">
  <div class="container">
    <h3>Accelerated By </h3>
    <div class="clearfix">&nbsp;</div>
    <div class="clearfix hidden-xs">&nbsp;</div>
    <div class="clearfix hidden-xs">&nbsp;</div>
    <div class="clearfix hidden-xs">&nbsp;</div>
    <div class="row no-mar wizardsteps">
   <img  src="nbdimages/Home/faster capital.png" width="150" height="50" style="margin-bottom:5px;" >
    <div style="font-size: 16px;
    line-height: 32px;">FasterCapital is a virtual incubator and an investment company. As an incubator, we help entrepreneurs build their technical start-up on a co-funding & co-founding basis. We will take care of all backend technical development of the start-ups we will be investing in and will allow entrepreneurs to focus on their core business, customer gathering and revenue generation.
We have a very unique and different approach to helping startups achieve their goals.
    </div>
    </div>
    end of progress bar 
  </div>
</section> -->


<section>
  <div class="container-fluid no-pad videos">
    <h3>Let's see what our customers are saying.</h3>
    <div class="clearfix">&nbsp;</div>
    <div class="clearfix">&nbsp;</div>
    <div class="col-md-6 col-sm-6 text-center">
      <embed src="https://www.youtube.com/v/wwOepwq0cs8?rel=0&amp;showinfo=0" wmode="transparent" type="application/x-shockwave-flash"  allowfullscreen="true" autoplay=1 title="Adobe Flash Player">
    </div>
      <div class="clearfix visible-xs">&nbsp;</div>
    <div class="col-md-6 col-sm-6 text-center">
      <embed src="https://www.youtube.com/v/qXj4owAQLt0?rel=0&amp;showinfo=0" wmode="transparent" type="application/x-shockwave-flash" allowfullscreen="true" autoplay=1 title="Adobe Flash Player">
    </div>
    <div class="clearfix">&nbsp;</div>
    <div class="clearfix">&nbsp;</div>
  </div>
</section>
<section class="foot">
  <div class="container-fluid">
    <div class="row">
      <div class="col-md-3 col-sm-3 as-bottom-rightborder">
        <div class="widget">
          <ul>
            <li><a href="aboutus.html">About us</a></li>
           <!--  <li><a href="csr.html">CSR</a></li> -->
            <li><a href="contact.html">Contact us</a></li>
           <!--  <li><a href="https://aurospaces.recruiterbox.com">Careers</a></li> -->
             <li><a href="http://community.aurospaces.com" target="_blank" >Auro Community</a></li>
          </ul>
        </div>
      </div>
      <!--/.col-md-3-->
      <div class="col-md-6 col-sm-6 as-bottom-rightborder">
        <div class="widget1">
          <p><span class="fa fa-quote-left"></span> At Aurospaces, we care for our partners,Our mission is to build the best marketplace for all services<span class="fa fa-quote-right "></span> </p>
          <p><a href="contact.html" style="color: #f9c603;">Become an Auro Professional <i class="fa fa-arrow-right"></i></a></p>
        </div>
        <br>
      </div>
      <!--/.col-md-3-->
      <div class="col-md-3 col-sm-3">
        <div class="widget as-left-bottom">
          <div class="clearfix hidden-xs">&nbsp;</div>
          <div class="clearfix hidden-xs">&nbsp;</div>
          <div class="col-md-12 col-sm-12 col-xs-6 ">
            <p><a href="https://play.google.com/store/apps/details?id=com.aurospace.customer&hl=en" target="_blank"><img class="img-responsive center-block" src="nbdimages/homepage/android-app.png" width="165" height="49"></a></p>
            <br>
          </div> 
         <!--  <p class="fb-text  hidden-xs">Follow Us on -->
          <div class="col-md-12 col-sm-12 col-xs-6">
            <p><a href="https://www.facebook.com/Aurospaces"><img class="img-responsive center-block" src="nbdimages/homepage/facebook.png" width="165" height="49"></a></p>
          <!--  <p><a href="https://www.facebook.com/Aurospaces"><img class="img-responsive facebook hidden-xs" src="nbdimages/icons/facebook.jpg"></a></p>
           <p><a href="https://plus.google.com/117846566525310882445/posts"><img class="img-responsive googleplay hidden-xs" src="nbdimages/icons/google_plus.png"></a></p>
           <p><a href="https://www.linkedin.com/company/3648496?trk=tyah&trkInfo=clickedVertical%3Acompany%2CentityType%3AentityHistoryName%2CclickedEntityId%3Acompany_3648496%2Cidx%3A0"><img class="img-responsive linkedin hidden-xs" src="nbdimages/icons/linkedin.png"></a></p>
           <p><a href="https://www.quora.com/Aurospaces"><img class="img-responsive quora hidden-xs" src="nbdimages/icons/quora.png"></a></p>
           <p><a href="https://twitter.com/Aurospaces"><img class="img-responsive twitter hidden-xs" src="nbdimages/icons/twitter.png"></a></p>
           <p><a href="https://www.youtube.com/channel/UCBPX0IjeVe0VIXoXi4x41Mw"><img class="img-responsive youtube hidden-xs" src="nbdimages/icons/youtube.png"></a></p>  -->
           </div>
          <!-- </p> -->
        </div>
      </div>
      <!--/.col-md-3--> 
    </div>
  </div>
</section>
<div class="footer">
  <div class="container-main">
    <div class="col-md-4 col-sm-4 col-xs-4 no-pad col-md-offset-4 col-sm-offset-4 text-center"> <a href="javascript:;">&copy; 2014 Aurospaces </a> </div>
    <div class="col-md-4 col-sm-4 col-xs-8 text-center"> <a href="terms&condititons.html"> Terms&amp;Conditions </a> &nbsp; &nbsp; <a href="privacypolicy.html"> Privacy Policy </a> 
</div>
  </div>
</div>
<script>(function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){(i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)})(window,document,'script','//www.google-analytics.com/analytics.js','ga');ga('create','UA-63399103-1','auto');ga('send','pageview');</script>
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>  -->
<script src="js/jquery.min.js"></script>  
<script src="js/bootstrap.min.js"></script>  
<script src="js/jquery.js"></script>


	<script type="text/javascript">
	var serviceNameId = "";
	var locationNameId = $("#loc_name").val();
	 var locationId ="";
	$(document).ready(function() {
		$("#locationid").val("");
		$("#serviceId").val("");
	});
	function booking() {
		//var locationId = $("#loc_id").val();
		if (locationId == null || locationId == "") {
			$("#locationBtn").css({
				"border-width" : "10px",
				"border-color" : "red"
			});
			return false;
		}
		var serviceId = $("#serviceId").val();
		if (serviceId == null || serviceId == "") {
			$("#serviceBtn").css({
				"border-width" : "10px",
				"border-color" : "red"
			});
			return false;
		}
		if (serviceId == null || serviceId == "" && locationId == null
				|| locationId == "") {
		} else {
			/* $("#addForm").attr("action", "browseServices/"+locationNameId+"/"+serviceNameId) ;
			$('<input type = "hidden" name = "locationId">').val(locationId).append("#addForm");
			$('<input type = "hidden" name = "serviceId">').val(serviceId).append("#addForm");
			$("#addForm").submit();											
			event.preventDefault(); */
		}
		location.href = "browseServices/" + locationNameId + "/"
				+ serviceNameId + "/" + locationId + "/" + serviceId;
	}
	function serviceFilter(id, locationName) {
		$("#locationBtn").css({
			"border-width" : "0px",
			"border-color" : "black"
		});
		var htmlText = "";
		 locationId = id;
		locationNameId = locationName;
		$("#locationid").val(locationId);
		 $.ajax({
			type : "POST",
			url : "forServices.json",
			data : "locationId=" + locationId,
			dataType : "json",
			success : function(response) {
				var optionsForClass = "";
				optionsForClass = $("#serviceId").empty();
				optionsForClass.append(new Option("--Select--", ""));
				$.each(response, function(i, tests) {
					var name=tests.serviceName;
					var id=tests.serviceId;
					var vid="'"+id+"'";
					if(tests.isbold == 1 ){
						//htmlText+ ='<li class="disli"><a style="font-size:110%" style="font-size:100%" id="${service.id}" ><b>${service.name}</b></a></li>
						htmlText+='<li class="disli"><a  style="font-size:110%;font-weight: 700;"  id='+id+' class="anchorlink" name = '+name+' href="#" onclick="formOperation(this.id,this.name);">'+name+'</a></li>'
					}else{
						if(tests.isdummy ==  1){
							htmlText+='<li class="disli"><a    id='+id+' class="anchorlink" name = '+name+' href="#" onclick="formOperation(this.id,this.name);">'+name+'</a></li>'	
						}else{
					htmlText+='<li><a id='+id+' class="anchorlink" name = '+name+' href="#" onclick="formOperation(this.id,this.name);">'+name+'</a></li>'
					}
					}
				});
				$("#chooseService").html(htmlText);
			},
			error : function(e) {
			},
			statusCode : {
				406 : function() {
			
				}
			}
		}); 
	}
	function formOperation(id, serviceName) {
		$("#serviceBtn").css({
			"border-width" : "0px",
			"border-color" : "black"
		});
		var htmlText = "";
		$("#serviceId").val(id);
		serviceNameId = serviceName.replace(/\s/g, "");
		 var serviceId =id;
		var locationId = $("#locationid").val();
		if(locationId != null && locationId != ""){
		}else{
		$.ajax({
			type : "POST",
			url : "getLocationsForService.json",
			data : "serviceId=" + serviceId,
			dataType : "json",
			success : function(response) {
				var optionsForClass = "";
				optionsForClass = $("#locationId").empty();
				$("#chooseLocation").html("");
				$.each(response, function(i, tests) {
					optionsForClass.append(new Option(tests.locationName,
							tests.locationId));
					var name=tests.locationName;
					var id=tests.locationId;
					var vid="'"+id+"'";
					//var htStr='<a href="javascript:forVendorDetails('+vid+')" >'+temp+'</a>';
					htmlText+='<li><a id='+id+' class="anchorlink" href="#" onclick="serviceFilter('+vid+');">'+name+'</a></li>'
				});
				$("#chooseLocation").html(htmlText);
			},
			error : function(e) {
			},
			statusCode : {
				406 : function() {
				}
			}
		});
		}
	}
	$(document.body).on(
			'click',
			'.dropdown-menu li',
			function(event) {
				var $target = $(event.currentTarget);
				if (!(($target).hasClass('disli'))) {
					$target.closest('.btn-group').find(
							'[data-bind="label"]').text($target.text())
							.end().children('.dropdown-toggle').dropdown(
									'toggle');
				}
				return false;
			});
	</script>


</body>
</html>
