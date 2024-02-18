export default function EmptyGridSpace({xs, sm, md, lg, xl, xxl}){
    let classes="";
    xs && (classes += " col-" + xs);
    sm && (classes += " col-sm-" + sm);
    md && (classes += " col-md-" + md);
    lg && (classes += " col-lg-" + lg);
    xl && (classes += " col-xl-" + xl);
    xxl && (classes += " col-xxl-" + xxl);
    return (
        <div className={classes}></div>
    )
}