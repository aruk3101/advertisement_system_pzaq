export default function EmptyGridSpace({xs, sm, md, lg, xl, xxl}){
    let classes = (xs && " col-" + xs) 
    + (sm && " col-sm-" + sm)
    + (md && " col-md-" + md)
    + (lg && " col-lg-" + lg)
    + (xl && " col-xl-" + xl)
    + (xxl && " col-xxl-" + xxl);

    return (
        <div className={classes}></div>
    )
}