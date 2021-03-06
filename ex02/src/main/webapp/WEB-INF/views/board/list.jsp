<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@include file="../includes/header.jsp" %>

            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header"> 테이블 </h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            
            
            
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading"> Board list Page 
                        <button id="regBtn" type="button" class="btn btn-xs pull-right">Register New Board</button>
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th>번호</th>
                                        <th>제목</th>
                                        <th>작성자</th>
                                        <th>작성일</th>
                                        <th>수정일</th>
                                    </tr>
                                </thead>
                                <c:forEach items="${list}" var="board">
                                <tr>
                                	<td><c:out value="${board.bno}" /> </td>
                                	<td><a href='/board/get?bno=<c:out value="${board.bno}"/>'>
                                	<c:out value="${board.title}"/></a></td>
                                	<td><c:out value="${board.writer}" /></td>
                                	<td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.regdate}"/></td>
                                	<td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.updateDate}"/></td>
                                </tr>
                                </c:forEach>
                            </table>
                            
                            <!-- Modal -->
                            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                            <h4 class="modal-title" id="myModalLabel">Modal title</h4>
                                        </div>
                                        <div class="modal-body">처리가 완료되었습니다.</div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                            <button type="button" class="btn btn-primary">Save changes</button>
                                        </div>
                                    </div>
                                    <!-- /.modal-content -->
                                </div>
                                <!-- /.modal-dialog -->
                            </div>
                            <!-- /.modal -->
                            
                            
                        </div>
                        <!--  end panel-body -->
                    </div>
                    <!-- end panel -->
                </div>
                <!-- end col-lg-6 -->
            </div>
            <!-- end row -->
<script type="text/javascript">
$(document).ready(function(){
	var result = '<c:out value="${result}"/>';
	//var result = "${result}";
	
	checkModal(result);
	
	//히스토리 체크 부분 추가 만약, 모든처리가 끝난 후에는 모당찰을 보여줄 필요가 없는 상태가된다.
	//history.replaceState를 사용하여 history.state를 체크를 통해 뒤로가기시 불필요한 모달 부분 처리.
	history.replaceState({},null,null);
	
	function checkModal(result) {
		
		if(result === '' || history.state ) {
			return;
		}
		
		if(parseInt(result) > 0) {
			$(".modal-body").html("게시글 "+ parseInt(result) + " 번이 등록되었습니다.") 
		}
		
		$("#myModal").modal("show")
	}
	
	// list 페이지중 Register New Board 버튼 클릭시 register페이지로 이동 처리.
	$("#regBtn").on("click", function(){
		self.location = "/board/register";
	});
	
});
</script>
            <%@include file="../includes/footer.jsp" %>
