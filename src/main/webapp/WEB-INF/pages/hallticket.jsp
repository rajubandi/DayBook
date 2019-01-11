
<div class="container-right">
	<!-- uiView:  -->
	<div ui-view="" class="ng-scope">
		<!-- uiView:  -->
		<div class="main-panel ng-scope" ui-view="">
			<form
				class="form-horizontal ng-valid ng-scope ng-dirty ng-valid-parse">
				<div class="panel panel-default">
					<div class="panel-heading">
						<div class="row form-inline">
							<div class="col-xs-4 heading">Search Criteria</div>
							<div class="col-xs-8 right-align">
								<label>Exam Type:</label><span exam-type-selector=""
									ng-model="selectedExamTypeId"
									class="ng-untouched ng-valid ng-isolate-scope ng-dirty ng-valid-parse"><select
									ng-model="selectedItem"
									class="form-control ng-pristine ng-untouched ng-valid"
									ng-options="item.Id as item.Name for item in model"><option
											value="0" selected="selected" label="FA -1">FA -1</option>
										<option value="1" label="FA-2">FA-2</option>
										<option value="2" label="FA-3">FA-3</option>
										<option value="3" label="FA-4">FA-4</option>
										<option value="4" label="SA-1">SA-1</option>
										<option value="5" label="SA-2">SA-2</option>
										<option value="6" label="SA-3">SA-3</option></select></span>
								<button ng-click="search()" class="btn btn-success">Search</button>
								<a
									ui-sref="Exams.PrintHallTickets({ETId:selectedExamTypeId, SIds:selectedStudentIds})"
									class="btn btn-success"
									ng-disabled="selectedStudentIds.length == 0 || !selectedExamTypeId"
									target="_blank" href="#/Exams/HallTickets/ExamType/9/Student/"
									disabled="disabled"> Print Hall Tickets for selected
									students</a>
							</div>
						</div>
					</div>
				</div>
				<div class="panel-body">
					<div search-criteria="" ng-model="filters"
						class="ng-untouched ng-valid ng-isolate-scope ng-dirty ng-valid-parse">
						<div class="row">
							<div class="col-xs-4">
								<div class="form-group">
									<label class="col-xs-4 control-label">Username</label>
									<div class="col-xs-8">
										<input type="text"
											class="form-control ng-pristine ng-untouched ng-valid"
											ng-model="filter.username">
									</div>
								</div>
							</div>
							<div class="col-xs-4">
								<div class="form-group">
									<label class="col-xs-4 control-label">Name</label>
									<div class="col-xs-8">
										<input type="text"
											class="form-control ng-pristine ng-untouched ng-valid"
											ng-model="filter.name">
									</div>
								</div>
							</div>
							<div class="col-xs-4">
								<div class="form-group">
									<label class="col-xs-5 control-label">SMS Contact
										Number</label>
									<div class="col-xs-7">
										<input type="text"
											class="form-control ng-pristine ng-untouched ng-valid"
											ng-model="filter.contactNumber">
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-xs-4">
								<div class="form-group">
									<label class="col-xs-4 control-label">Class</label>
									<div class="col-xs-8">
										<span class-selector="" os-cs-any="true"
											ng-model="filter.classId"
											class="ng-pristine ng-untouched ng-valid ng-isolate-scope"><select
											ng-model="selectedItem"
											class="form-control ng-pristine ng-untouched ng-valid"
											ng-options="item.Id as item.Name for item in model"><option
													value="0" selected="selected" label="Any">Any</option>
												<option value="1" label="NURSERY">NURSERY</option>
												<option value="2" label="LKG">LKG</option>
												<option value="3" label="UKG">UKG</option>
												<option value="4" label="CLASS I">CLASS I</option>
												<option value="5" label="CLASS II">CLASS II</option>
												<option value="6" label="CLASS III">CLASS III</option>
												<option value="7" label="CLASS IV">CLASS IV</option>
												<option value="8" label="CLASS V">CLASS V</option>
												<option value="9" label="CLASS VI">CLASS VI</option>
												<option value="10" label="CLASS VII">CLASS VII</option>
												<option value="11" label="CLASS VIII">CLASS VIII</option>
												<option value="12" label="CLASSIX">CLASSIX</option></select></span>
									</div>
								</div>
							</div>
							<div class="col-xs-4">
								<div class="form-group">
									<label class="col-xs-4 control-label">Section</label>
									<div class="col-xs-8">
										<span section-selector="" os-cs-any="true" os-ss-class="0"
											ng-model="filter.sectionId"
											class="ng-pristine ng-untouched ng-valid ng-isolate-scope"><select
											ng-model="selectedItem"
											class="form-control ng-pristine ng-untouched ng-valid"
											ng-options="item.Id as item.Name for item in model"><option
													value="0" selected="selected" label="Any">Any</option>
												<option value="1" label="NURSERY A">NURSERY A</option>
												<option value="2" label="LKG A">LKG A</option>
												<option value="3" label="UKG A">UKG A</option>
												<option value="4" label="CLASS IA">CLASS IA</option>
												<option value="5" label="CLASSIIA">CLASSIIA</option>
												<option value="6" label="CLASS IIIA">CLASS IIIA</option>
												<option value="7" label="CLASSIVA">CLASSIVA</option>
												<option value="8" label="CLASS-VA">CLASS-VA</option>
												<option value="9" label="CLASS VIA">CLASS VIA</option>
												<option value="10" label="CLASS VIIA">CLASS VIIA</option>
												<option value="11" label="LKG B">LKG B</option>
												<option value="12" label="CLASS VIIIA">CLASS VIIIA</option>
												<option value="13" label="CLASSIXA">CLASSIXA</option>
												<option value="14" label="UKG B">UKG B</option></select></span>
									</div>
								</div>
							</div>
							<div class="col-xs-4">
								<div class="form-group">
									<label class="col-xs-5 control-label">RollNo</label>
									<div class="col-xs-7">
										<input type="text"
											class="form-control ng-pristine ng-untouched ng-valid"
											ng-model="filter.rollNo">
									</div>
								</div>
							</div>
						</div>
						<!-- ngIf: admissionidFilter -->
						<!-- ngIf: additionalFilters -->
					</div>
				</div>
			</form>
			<div search-results="" manage-route="User.ManageStudent"
				manage-status="1" os-sr-selection="true"
				os-sr-show-operations="false" get-method="getCurrentStudents"
				search-result-filters="{}" ng-model="selectedStudents"
				class="ng-untouched ng-valid ng-scope ng-isolate-scope ng-dirty ng-valid-parse">
				<div class="panel panel-default">
					<div class="panel-heading">
						<div class="row">
							<div class="col-xs-8 heading">
								<span><span>Students</span> </span>
							</div>
							<!-- ngIf: exportResults -->
						</div>
					</div>
					<!-- ngIf: showCustomData -->
					<!-- ngIf: !showCustomData -->
					<div class="panel-body ng-scope" ng-if="!showCustomData">
						<table
							class="table table-striped table-selectable ng-scope ng-table"
							ng-table="tableParams">
							<!-- ngInclude: templates.header -->
							<thead ng-include="templates.header" class="ng-scope">
								<tr class="ng-scope">
									<!-- ngRepeat: $column in $columns -->
									<th title=" " ng-repeat="$column in $columns"
										ng-class="{ 'sortable': $column.sortable(this), 'sort-asc': params.sorting()[$column.sortable(this)]=='asc', 'sort-desc': params.sorting()[$column.sortable(this)]=='desc' }"
										ng-click="sortBy($column, $event)"
										ng-show="$column.show(this)"
										ng-init="template=$column.headerTemplateURL(this)"
										class="header ">
										<!-- ngIf: !template --> <!-- ngIf: template -->
										<!-- ngInclude: template -->
										<div ng-if="template" ng-show="template" ng-include="template"
											class="ng-scope">
											<input type="checkbox" ng-model="Status.allChecked"
												id="select_all" name="filter-checkbox" value=""
												class="ng-pristine ng-untouched ng-valid ng-scope">
										</div>
										<!-- end ngIf: template -->
									</th>
									<!-- end ngRepeat: $column in $columns -->
									<th title=" " ng-repeat="$column in $columns"
										ng-class="{ 'sortable': $column.sortable(this), 'sort-asc': params.sorting()[$column.sortable(this)]=='asc', 'sort-desc': params.sorting()[$column.sortable(this)]=='desc' }"
										ng-click="sortBy($column, $event)"
										ng-show="$column.show(this)"
										ng-init="template=$column.headerTemplateURL(this)"
										class="header ">
										<!-- ngIf: !template -->
										<div ng-if="!template" ng-show="!template"
											class="ng-table-header ng-scope"
											ng-class="{'sort-indicator': params.settings().sortingIndicator=='div'}">
											<span ng-bind="$column.title(this)"
												ng-class="{'sort-indicator': params.settings().sortingIndicator=='span'}"
												class="ng-binding sort-indicator">S.No</span>
										</div>
										<!-- end ngIf: !template --> <!-- ngIf: template -->
									</th>
									<!-- end ngRepeat: $column in $columns -->
									<th title=" " ng-repeat="$column in $columns"
										ng-class="{ 'sortable': $column.sortable(this), 'sort-asc': params.sorting()[$column.sortable(this)]=='asc', 'sort-desc': params.sorting()[$column.sortable(this)]=='desc' }"
										ng-click="sortBy($column, $event)"
										ng-show="$column.show(this)"
										ng-init="template=$column.headerTemplateURL(this)"
										class="header  sortable">
										<!-- ngIf: !template -->
										<div ng-if="!template" ng-show="!template"
											class="ng-table-header ng-scope"
											ng-class="{'sort-indicator': params.settings().sortingIndicator=='div'}">
											<span ng-bind="$column.title(this)"
												ng-class="{'sort-indicator': params.settings().sortingIndicator=='span'}"
												class="ng-binding sort-indicator">Class</span>
										</div>
										<!-- end ngIf: !template --> <!-- ngIf: template -->
									</th>
									<!-- end ngRepeat: $column in $columns -->
									<th title=" " ng-repeat="$column in $columns"
										ng-class="{ 'sortable': $column.sortable(this), 'sort-asc': params.sorting()[$column.sortable(this)]=='asc', 'sort-desc': params.sorting()[$column.sortable(this)]=='desc' }"
										ng-click="sortBy($column, $event)"
										ng-show="$column.show(this)"
										ng-init="template=$column.headerTemplateURL(this)"
										class="header  sortable">
										<!-- ngIf: !template -->
										<div ng-if="!template" ng-show="!template"
											class="ng-table-header ng-scope"
											ng-class="{'sort-indicator': params.settings().sortingIndicator=='div'}">
											<span ng-bind="$column.title(this)"
												ng-class="{'sort-indicator': params.settings().sortingIndicator=='span'}"
												class="ng-binding sort-indicator">Section</span>
										</div>
										<!-- end ngIf: !template --> <!-- ngIf: template -->
									</th>
									<!-- end ngRepeat: $column in $columns -->
									<th title=" " ng-repeat="$column in $columns"
										ng-class="{ 'sortable': $column.sortable(this), 'sort-asc': params.sorting()[$column.sortable(this)]=='asc', 'sort-desc': params.sorting()[$column.sortable(this)]=='desc' }"
										ng-click="sortBy($column, $event)"
										ng-show="$column.show(this)"
										ng-init="template=$column.headerTemplateURL(this)"
										class="header  sortable">
										<!-- ngIf: !template -->
										<div ng-if="!template" ng-show="!template"
											class="ng-table-header ng-scope"
											ng-class="{'sort-indicator': params.settings().sortingIndicator=='div'}">
											<span ng-bind="$column.title(this)"
												ng-class="{'sort-indicator': params.settings().sortingIndicator=='span'}"
												class="ng-binding sort-indicator">RollNo</span>
										</div>
										<!-- end ngIf: !template --> <!-- ngIf: template -->
									</th>
									<!-- end ngRepeat: $column in $columns -->
									<th title=" " ng-repeat="$column in $columns"
										ng-class="{ 'sortable': $column.sortable(this), 'sort-asc': params.sorting()[$column.sortable(this)]=='asc', 'sort-desc': params.sorting()[$column.sortable(this)]=='desc' }"
										ng-click="sortBy($column, $event)"
										ng-show="$column.show(this)"
										ng-init="template=$column.headerTemplateURL(this)"
										class="header  sortable">
										<!-- ngIf: !template -->
										<div ng-if="!template" ng-show="!template"
											class="ng-table-header ng-scope"
											ng-class="{'sort-indicator': params.settings().sortingIndicator=='div'}">
											<span ng-bind="$column.title(this)"
												ng-class="{'sort-indicator': params.settings().sortingIndicator=='span'}"
												class="ng-binding sort-indicator">Username</span>
										</div>
										<!-- end ngIf: !template --> <!-- ngIf: template -->
									</th>
									<!-- end ngRepeat: $column in $columns -->
									<th title=" " ng-repeat="$column in $columns"
										ng-class="{ 'sortable': $column.sortable(this), 'sort-asc': params.sorting()[$column.sortable(this)]=='asc', 'sort-desc': params.sorting()[$column.sortable(this)]=='desc' }"
										ng-click="sortBy($column, $event)"
										ng-show="$column.show(this)"
										ng-init="template=$column.headerTemplateURL(this)"
										class="header  sortable sort-asc">
										<!-- ngIf: !template -->
										<div ng-if="!template" ng-show="!template"
											class="ng-table-header ng-scope"
											ng-class="{'sort-indicator': params.settings().sortingIndicator=='div'}">
											<span ng-bind="$column.title(this)"
												ng-class="{'sort-indicator': params.settings().sortingIndicator=='span'}"
												class="ng-binding sort-indicator">Full Name</span>
										</div>
										<!-- end ngIf: !template --> <!-- ngIf: template -->
									</th>
									<!-- end ngRepeat: $column in $columns -->
									<th title=" " ng-repeat="$column in $columns"
										ng-class="{ 'sortable': $column.sortable(this), 'sort-asc': params.sorting()[$column.sortable(this)]=='asc', 'sort-desc': params.sorting()[$column.sortable(this)]=='desc' }"
										ng-click="sortBy($column, $event)"
										ng-show="$column.show(this)"
										ng-init="template=$column.headerTemplateURL(this)"
										class="header  sortable">
										<!-- ngIf: !template -->
										<div ng-if="!template" ng-show="!template"
											class="ng-table-header ng-scope"
											ng-class="{'sort-indicator': params.settings().sortingIndicator=='div'}">
											<span ng-bind="$column.title(this)"
												ng-class="{'sort-indicator': params.settings().sortingIndicator=='span'}"
												class="ng-binding sort-indicator">Contact Number</span>
										</div>
										<!-- end ngIf: !template --> <!-- ngIf: template -->
									</th>
									<!-- end ngRepeat: $column in $columns -->
									<th title=" " ng-repeat="$column in $columns"
										ng-class="{ 'sortable': $column.sortable(this), 'sort-asc': params.sorting()[$column.sortable(this)]=='asc', 'sort-desc': params.sorting()[$column.sortable(this)]=='desc' }"
										ng-click="sortBy($column, $event)"
										ng-show="$column.show(this)"
										ng-init="template=$column.headerTemplateURL(this)"
										class="header  sortable">
										<!-- ngIf: !template -->
										<div ng-if="!template" ng-show="!template"
											class="ng-table-header ng-scope"
											ng-class="{'sort-indicator': params.settings().sortingIndicator=='div'}">
											<span ng-bind="$column.title(this)"
												ng-class="{'sort-indicator': params.settings().sortingIndicator=='span'}"
												class="ng-binding sort-indicator">Contact Number2</span>
										</div>
										<!-- end ngIf: !template --> <!-- ngIf: template -->
									</th>
									<!-- end ngRepeat: $column in $columns -->
									<th title=" " ng-repeat="$column in $columns"
										ng-class="{ 'sortable': $column.sortable(this), 'sort-asc': params.sorting()[$column.sortable(this)]=='asc', 'sort-desc': params.sorting()[$column.sortable(this)]=='desc' }"
										ng-click="sortBy($column, $event)"
										ng-show="$column.show(this)"
										ng-init="template=$column.headerTemplateURL(this)"
										class="header  sortable">
										<!-- ngIf: !template -->
										<div ng-if="!template" ng-show="!template"
											class="ng-table-header ng-scope"
											ng-class="{'sort-indicator': params.settings().sortingIndicator=='div'}">
											<span ng-bind="$column.title(this)"
												ng-class="{'sort-indicator': params.settings().sortingIndicator=='span'}"
												class="ng-binding sort-indicator">Parent</span>
										</div>
										<!-- end ngIf: !template --> <!-- ngIf: template -->
									</th>
									<!-- end ngRepeat: $column in $columns -->
									<th title=" " ng-repeat="$column in $columns"
										ng-class="{ 'sortable': $column.sortable(this), 'sort-asc': params.sorting()[$column.sortable(this)]=='asc', 'sort-desc': params.sorting()[$column.sortable(this)]=='desc' }"
										ng-click="sortBy($column, $event)"
										ng-show="$column.show(this)"
										ng-init="template=$column.headerTemplateURL(this)"
										class="header  sortable ng-hide">
										<!-- ngIf: !template -->
										<div ng-if="!template" ng-show="!template"
											class="ng-table-header ng-scope"
											ng-class="{'sort-indicator': params.settings().sortingIndicator=='div'}">
											<span ng-bind="$column.title(this)"
												ng-class="{'sort-indicator': params.settings().sortingIndicator=='span'}"
												class="ng-binding sort-indicator">Reason For Leaving</span>
										</div>
										<!-- end ngIf: !template --> <!-- ngIf: template -->
									</th>
									<!-- end ngRepeat: $column in $columns -->
									<th title=" " ng-repeat="$column in $columns"
										ng-class="{ 'sortable': $column.sortable(this), 'sort-asc': params.sorting()[$column.sortable(this)]=='asc', 'sort-desc': params.sorting()[$column.sortable(this)]=='desc' }"
										ng-click="sortBy($column, $event)"
										ng-show="$column.show(this)"
										ng-init="template=$column.headerTemplateURL(this)"
										class="header  sortable ng-hide">
										<!-- ngIf: !template -->
										<div ng-if="!template" ng-show="!template"
											class="ng-table-header ng-scope"
											ng-class="{'sort-indicator': params.settings().sortingIndicator=='div'}">
											<span ng-bind="$column.title(this)"
												ng-class="{'sort-indicator': params.settings().sortingIndicator=='span'}"
												class="ng-binding sort-indicator">Religion</span>
										</div>
										<!-- end ngIf: !template --> <!-- ngIf: template -->
									</th>
									<!-- end ngRepeat: $column in $columns -->
									<th title=" " ng-repeat="$column in $columns"
										ng-class="{ 'sortable': $column.sortable(this), 'sort-asc': params.sorting()[$column.sortable(this)]=='asc', 'sort-desc': params.sorting()[$column.sortable(this)]=='desc' }"
										ng-click="sortBy($column, $event)"
										ng-show="$column.show(this)"
										ng-init="template=$column.headerTemplateURL(this)"
										class="header  sortable ng-hide">
										<!-- ngIf: !template -->
										<div ng-if="!template" ng-show="!template"
											class="ng-table-header ng-scope"
											ng-class="{'sort-indicator': params.settings().sortingIndicator=='div'}">
											<span ng-bind="$column.title(this)"
												ng-class="{'sort-indicator': params.settings().sortingIndicator=='span'}"
												class="ng-binding sort-indicator">Caste</span>
										</div>
										<!-- end ngIf: !template --> <!-- ngIf: template -->
									</th>
									<!-- end ngRepeat: $column in $columns -->
									<th title=" " ng-repeat="$column in $columns"
										ng-class="{ 'sortable': $column.sortable(this), 'sort-asc': params.sorting()[$column.sortable(this)]=='asc', 'sort-desc': params.sorting()[$column.sortable(this)]=='desc' }"
										ng-click="sortBy($column, $event)"
										ng-show="$column.show(this)"
										ng-init="template=$column.headerTemplateURL(this)"
										class="header  sortable ng-hide">
										<!-- ngIf: !template -->
										<div ng-if="!template" ng-show="!template"
											class="ng-table-header ng-scope"
											ng-class="{'sort-indicator': params.settings().sortingIndicator=='div'}">
											<span ng-bind="$column.title(this)"
												ng-class="{'sort-indicator': params.settings().sortingIndicator=='span'}"
												class="ng-binding sort-indicator">AdmissionId</span>
										</div>
										<!-- end ngIf: !template --> <!-- ngIf: template -->
									</th>
									<!-- end ngRepeat: $column in $columns -->
									<th title=" " ng-repeat="$column in $columns"
										ng-class="{ 'sortable': $column.sortable(this), 'sort-asc': params.sorting()[$column.sortable(this)]=='asc', 'sort-desc': params.sorting()[$column.sortable(this)]=='desc' }"
										ng-click="sortBy($column, $event)"
										ng-show="$column.show(this)"
										ng-init="template=$column.headerTemplateURL(this)"
										class="header  ng-hide">
										<!-- ngIf: !template -->
										<div ng-if="!template" ng-show="!template"
											class="ng-table-header ng-scope"
											ng-class="{'sort-indicator': params.settings().sortingIndicator=='div'}">
											<span ng-bind="$column.title(this)"
												ng-class="{'sort-indicator': params.settings().sortingIndicator=='span'}"
												class="ng-binding sort-indicator">Operations</span>
										</div>
										<!-- end ngIf: !template --> <!-- ngIf: template -->
									</th>
									<!-- end ngRepeat: $column in $columns -->
								</tr>
								<tr ng-show="show_filter"
									class="ng-table-filters ng-scope ng-hide">
									<!-- ngRepeat: $column in $columns -->
									<th data-title-text=" " ng-repeat="$column in $columns"
										ng-show="$column.show(this)" class="filter ng-scope">
										<!-- ngRepeat: (name, filter) in $column.filter(this) -->
									</th>
									<!-- end ngRepeat: $column in $columns -->
									<th data-title-text="S.No" ng-repeat="$column in $columns"
										ng-show="$column.show(this)" class="filter ng-scope">
										<!-- ngRepeat: (name, filter) in $column.filter(this) -->
									</th>
									<!-- end ngRepeat: $column in $columns -->
									<th data-title-text="Class" ng-repeat="$column in $columns"
										ng-show="$column.show(this)" class="filter ng-scope">
										<!-- ngRepeat: (name, filter) in $column.filter(this) -->
									</th>
									<!-- end ngRepeat: $column in $columns -->
									<th data-title-text="Section" ng-repeat="$column in $columns"
										ng-show="$column.show(this)" class="filter ng-scope">
										<!-- ngRepeat: (name, filter) in $column.filter(this) -->
									</th>
									<!-- end ngRepeat: $column in $columns -->
									<th data-title-text="RollNo" ng-repeat="$column in $columns"
										ng-show="$column.show(this)" class="filter ng-scope">
										<!-- ngRepeat: (name, filter) in $column.filter(this) -->
									</th>
									<!-- end ngRepeat: $column in $columns -->
									<th data-title-text="Username" ng-repeat="$column in $columns"
										ng-show="$column.show(this)" class="filter ng-scope">
										<!-- ngRepeat: (name, filter) in $column.filter(this) -->
									</th>
									<!-- end ngRepeat: $column in $columns -->
									<th data-title-text="Full Name" ng-repeat="$column in $columns"
										ng-show="$column.show(this)" class="filter ng-scope">
										<!-- ngRepeat: (name, filter) in $column.filter(this) -->
									</th>
									<!-- end ngRepeat: $column in $columns -->
									<th data-title-text="Contact Number"
										ng-repeat="$column in $columns" ng-show="$column.show(this)"
										class="filter ng-scope">
										<!-- ngRepeat: (name, filter) in $column.filter(this) -->
									</th>
									<!-- end ngRepeat: $column in $columns -->
									<th data-title-text="Contact Number2"
										ng-repeat="$column in $columns" ng-show="$column.show(this)"
										class="filter ng-scope">
										<!-- ngRepeat: (name, filter) in $column.filter(this) -->
									</th>
									<!-- end ngRepeat: $column in $columns -->
									<th data-title-text="Parent" ng-repeat="$column in $columns"
										ng-show="$column.show(this)" class="filter ng-scope">
										<!-- ngRepeat: (name, filter) in $column.filter(this) -->
									</th>
									<!-- end ngRepeat: $column in $columns -->
									<th data-title-text="Reason For Leaving"
										ng-repeat="$column in $columns" ng-show="$column.show(this)"
										class="filter ng-scope ng-hide">
										<!-- ngRepeat: (name, filter) in $column.filter(this) -->
									</th>
									<!-- end ngRepeat: $column in $columns -->
									<th data-title-text="Religion" ng-repeat="$column in $columns"
										ng-show="$column.show(this)" class="filter ng-scope ng-hide">
										<!-- ngRepeat: (name, filter) in $column.filter(this) -->
									</th>
									<!-- end ngRepeat: $column in $columns -->
									<th data-title-text="Caste" ng-repeat="$column in $columns"
										ng-show="$column.show(this)" class="filter ng-scope ng-hide">
										<!-- ngRepeat: (name, filter) in $column.filter(this) -->
									</th>
									<!-- end ngRepeat: $column in $columns -->
									<th data-title-text="AdmissionId"
										ng-repeat="$column in $columns" ng-show="$column.show(this)"
										class="filter ng-scope ng-hide">
										<!-- ngRepeat: (name, filter) in $column.filter(this) -->
									</th>
									<!-- end ngRepeat: $column in $columns -->
									<th data-title-text="Operations"
										ng-repeat="$column in $columns" ng-show="$column.show(this)"
										class="filter ng-scope ng-hide">
										<!-- ngRepeat: (name, filter) in $column.filter(this) -->
									</th>
									<!-- end ngRepeat: $column in $columns -->
								</tr>
							</thead>
							<tbody>
								<!-- ngRepeat: item in $data -->
							</tbody>
						</table>
						<div ng-table-pagination="params"
							template-url="templates.pagination"
							class="ng-scope ng-isolate-scope">
							<!-- ngInclude: templateUrl -->
							<div ng-include="templateUrl" class="ng-scope">
								<!-- ngIf: params.data.length -->
							</div>
						</div>
					</div>
					<!-- end ngIf: !showCustomData -->
				</div>
			</div>
		</div>
	</div>
</div>