/*$(function () {
    Pagination.init();
});*/
/*
var Pagination = {
    pagination: {currentPage: 3, total: 1,}, paginationTemplate: $("#pagination").html(), init: function () {
        this.fetchHistory();
    }, fetchHistory: function () {
        this.pagination.total = 16;
        this.initPagination();
    }, initPagination: function () {
        var element = document.getElementById("pagination");
        $("#pagination").html("");
        var fragment = document.createDocumentFragment();
        if (this.pagination.total > 1) {
            if (this.pagination.total > 5) {
                var li = this.getPaginationTemplate("上一页")
                fragment.appendChild(li);
                if (this.pagination.currentPage <= 5) {
                    for (let i = 1; i <= 5; i++) {
                        var li = this.getPaginationTemplate(i)
                        fragment.appendChild(li);
                        if (i === this.pagination.currentPage) {
                            li.setAttribute("class", 'yb-reward-history__pagination yb-reward-history__pagination-active')
                        }
                    }
                } else {
                    console.log(this.pagination.currentPage)
                    var li = this.getPaginationTemplate("moreStart");
                    fragment.appendChild(li);
                    for (let i = this.pagination.currentPage - 2; i <= this.pagination.currentPage + 2 && i < this.pagination.total; i++) {
                        var li = this.getPaginationTemplate(i)
                        fragment.appendChild(li);
                        if (i === this.pagination.currentPage) {
                            li.setAttribute("class", 'yb-reward-history__pagination yb-reward-history__pagination-active')
                        }
                    }
                }
                if (this.pagination.currentPage === 1 || this.pagination.currentPage + 3 !== this.pagination.total && this.pagination.currentPage + 2 !== this.pagination.total && this.pagination.currentPage + 1 !== this.pagination.total && this.pagination.currentPage !== this.pagination.total) {
                    var li = this.getPaginationTemplate("moreEnd")
                    fragment.appendChild(li);
                    var li = this.getPaginationTemplate(this.pagination.total)
                    fragment.appendChild(li);
                } else {
                    var li = this.getPaginationTemplate(this.pagination.total)
                    if (this.pagination.currentPage === this.pagination.total) {
                        li.setAttribute("class", 'yb-reward-history__pagination yb-reward-history__pagination-active')
                    }
                    fragment.appendChild(li);
                }
                var li = this.getPaginationTemplate("下一页");
                fragment.appendChild(li);
            } else {
                for (let i = 1; i <= 5; i++) {
                    var li = this.getPaginationTemplate(i)
                    fragment.appendChild(li);
                    if (i === this.pagination.currentPage) {
                        li.setAttribute("class", 'yb-reward-history__pagination yb-reward-history__pagination-active')
                    }
                }
            }
            element.appendChild(fragment)
        }
    }, getPaginationTemplate: function (index) {
        var li = document.createElement('a');
        li.text = index;
        if (index === "moreStart" || index === "moreEnd") {
            li.text = "...";
        }
        li.id = `pagination${index}`;
        li.onclick = function (event) {
            this.changePagination(index)
            this.fetchHistory()
        }.bind(this);
        li.setAttribute("href", 'javascript:void(0)')
        li.setAttribute("class", 'yb-reward-history__pagination')
        return li;
    }, changePagination: function (index) {
        if (index === "上一页" && this.pagination.currentPage !== 1) {
            this.pagination.currentPage -= 1;
        } else if (index === "下一页" && this.pagination.currentPage !== this.pagination.total) {
            this.pagination.currentPage += 1;
        } else if (index === "moreStart") {
            if (this.pagination.currentPage - 3 > 1) {
                this.pagination.currentPage -= 3;
            }
        } else if (index === "moreEnd") {
            if (this.pagination.currentPage + 3 < this.pagination.total) {
                if (this.pagination.currentPage === 1) {
                    this.pagination.currentPage = 6;
                } else {
                    this.pagination.currentPage += 3;
                }
            }
        } else if (parseInt(index)) {
            this.pagination.currentPage = index;
        }
        this.initPagination();
    }
}*/
