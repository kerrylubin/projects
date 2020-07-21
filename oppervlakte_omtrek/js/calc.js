class calculate
{
    constructor()
    {

    }

    calculateCorners(ar)
    {
        var cAr = [];
        for(let i = 0; i < ar.length; i++)
        {
            var n = this.nxt(i,ar);
            var l = this.lst(i,ar);
         
            var hor = ar[n].x - ar[i].x;
            var ver = ar[n].y - ar[i].y;

            var hor2 = ar[l].x - ar[i].x;
            var ver2 = ar[l].y - ar[i].y;

            var horI = ar[n].x - ar[l].x; 
            var verI = ar[n].y - ar[l].y;

            var s1 = this.getPythagoras(hor,ver);
            var s2 = this.getPythagoras(horI,verI);
            var s3 = this.getPythagoras(hor2,ver2);

            var out = this.solveTriangle(s1, s2, s3, null, null, null)[1];
            cAr.push(parseFloat(out.toFixed(1)));
        }

        return cAr;
    }

    cornerDirection(cur,betw,deg)
    {
        var dif = cur - betw;
        if(dif < 0)
        {
            return deg;
        }
        else if(dif === 0)
        {
            return 180;
        }
        else if(dif > 0)
        {
            if(dif <= 180)
            {
                return 360 - deg;
            }
            else
            {
                return deg;
            }
        }
    }

    getWedgeRotation(i,ar)
    {
        var n = this.nxt(i,ar);
        var p = this.prev(i,ar);
        var angleDeg = Math.atan2(ar[n].y - ar[i].y, ar[n].x - ar[i].x) * 180 / Math.PI;
        return angleDeg;
    }

    centroid(poly)
    {
        var polygon = this.flatten(poly);
        var i = -1,
        n = polygon.length,
        x = 0,
        y = 0,
        a,
        b = polygon[n - 1],
        c,
        k = 0;

        while (++i < n)
        {
            a = b;
            b = polygon[i];
            k += c = a[0] * b[1] - b[0] * a[1];
            x += (a[0] + b[0]) * c;
            y += (a[1] + b[1]) * c;
        }

        return k *= 3, [x / k, y / k];
        //return {x:x / k, y:y / k};
    }

    flatten(poly)
    {
        var ar = [];
        for(var i = 0; i < poly.length; i++)
        {
            ar.push([poly[i].x,poly[i].y]);
        }

        return ar;
    }

    roundOff(n,r)
    {
        var num = n.toString();
        if(num.indexOf('.') > -1)
        {
            if(num.indexOf('.99') > -1)
            {
                return Math.ceil(n).toString();
            }
            else
            {
                var fixed = parseFloat(num).toFixed(r);

                var del = '.';
                for(let i = 0; i < r; i++)
                {
                    del += '0';
                }
                var f2 = fixed.replace(del,'');
                var reg = new RegExp(/(?=.*?\.)(.*?[1-9])(?!.*?\.)(?=0*$)|^.*$/);
                return f2.match(reg)[0];
            } 
        }
        else
        {
            return num;
        }
    }

    clockWise(center,ar)
    {
        var s = this;
        var degs = [];
        var mode = 'CCW';
        var newA = [];
        for(let i = 0; i < ar.length; i++)
        {
            var r = Math.atan2(ar[i].y - center.y, ar[i].x - center.x);
            degs.push(r);
        }
        for(let i = 0; i < degs.length; i++)
        {
            if(degs[i - 1] !== undefined && degs[i - 1] < degs[i])
            {
                mode = 'CW';
            }
        }

        if(mode === 'CCW')
        {
            for(let i = ar.length - 1; i > -1; i--)
            {
                newA.push(ar[i]);
            }

            return newA;
        }
        else
        {
            return ar;
        }
    }

    extremes(ar,p)
    {
        return ar.slice(0).sort(function(a,b)
        {
            return (a[p] > b[p]) ? 1 : (a[p] < b[p]) ? -1 : 0;
        });
    }

    nxt(index,ar)
    {
        if(index === ar.length - 1)
        {
            return 0;
        }
        else
        {
            return index + 1;
        }
    }

    lst(index,ar)
    {
        if(index > 0)
        {
            return (index + (ar.length - 1)) - ar.length;
        }
        else
        {
            return index + (ar.length - 1);
        }
    }

    prev(index,ar)
    {
        if(index > 0)
        {
            return index - 1;
        }
        else
        {
            return ar.length - 1;
        }
    }

    getPythagoras(hor,ver)
    {
        var s = Math.pow(hor, 2) + Math.pow(ver, 2)
        return Math.sqrt(s);
    }

    solveAngle(a, b, c)
    {
        var temp = (a * a + b * b - c * c) / (2 * a * b);
        if (this.and(temp >= -1, 0.9999999 >= temp))
            return this.radToDeg(Math.acos(temp));
        else if (1 >= temp)  // Explained in https://www.nayuki.io/page/numerically-stable-law-of-cosines
            return this.radToDeg(Math.sqrt((c * c - (a - b) * (a - b)) / (a * b)));
        /*else
            throw "No solution";*/
    }

    solveTriangle(a, b, c, A, B, C)
    {
        var sides  = (a != null) + (b != null) + (c != null);  // Boolean to integer conversion
        var angles = (A != null) + (B != null) + (C != null);  // Boolean to integer conversion
        var area, status;
        
        if (sides + angles != 3)
            throw "Give exactly 3 pieces of information";
        else if (sides == 0)
            throw "Give at least one side length";
        
        else if (sides == 3) {
            status = "Side side side (SSS) case";
           /* if (c >= a + b || a >= b + c || b >= c + a)
                throw status + " - No solution";*/
            A = this.solveAngle(b, c, a);
            B = this.solveAngle(c, a, b);
            C = this.solveAngle(a, b, c);
            // Heron's formula
            var s = (a + b + c) / 2;
            area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
            
        } else if (angles == 2) {
            status = "Angle side angle (ASA) case";
            // Find missing angle
            if (A == null) A = 180 - B - C;
            if (B == null) B = 180 - C - A;
            if (C == null) C = 180 - A - B;
            /*if (0 >= A || 0 >= B || 0 >= C)
                throw status + " - No solution";*/
            var sinA = Math.sin(this.degToRad(A));
            var sinB = Math.sin(this.degToRad(B));
            var sinC = Math.sin(this.degToRad(C));
            // Use law of sines to find sides
            var ratio;  // side / sin(angle)
            if (a != null) { ratio = a / sinA; area = a * ratio * sinB * sinC / 2; }
            if (b != null) { ratio = b / sinB; area = b * ratio * sinC * sinA / 2; }
            if (c != null) { ratio = c / sinC; area = c * ratio * sinA * sinB / 2; }
            if (a == null) a = ratio * sinA;
            if (b == null) b = ratio * sinB;
            if (c == null) c = ratio * sinC;
            
        } else if (this.and(A != null, a == null) || this.and(B != null, b == null) || this.and(C != null, c == null)) {
            status = "Side angle side (SAS) case";
            /*if (this.and(A != null, A >= 180) || this.and(B != null, B >= 180) || this.and(C != null, C >= 180))
                throw status + " - No solution";*/
            if (a == null) a = this.solveSide(b, c, A);
            if (b == null) b = this.solveSide(c, a, B);
            if (c == null) c = this.solveSide(a, b, C);
            if (A == null) A = this.solveAngle(b, c, a);
            if (B == null) B = this.solveAngle(c, a, b);
            if (C == null) C = this.solveAngle(a, b, c);
            if (A != null) area = b * c * Math.sin(this.degToRad(A)) / 2;
            if (B != null) area = c * a * Math.sin(this.degToRad(B)) / 2;
            if (C != null) area = a * b * Math.sin(this.degToRad(C)) / 2;
            
        } else {
            status = "Side side angle (SSA) case - ";
            var knownSide, knownAngle, partialSide;
            if (this.and(a != null, A != null)) { knownSide = a; knownAngle = A; }
            if (this.and(b != null, B != null)) { knownSide = b; knownAngle = B; }
            if (this.and(c != null, C != null)) { knownSide = c; knownAngle = C; }
            if (this.and(a != null, A == null)) partialSide = a;
            if (this.and(b != null, B == null)) partialSide = b;
            if (this.and(c != null, C == null)) partialSide = c;
            /*if (knownAngle >= 180)
                throw status + "No solution";*/
            var ratio = knownSide / Math.sin(this.degToRad(knownAngle));
            var temp = partialSide / ratio;  // sin(partialAngle)
            var partialAngle, unknownSide, unknownAngle;
            /*if (temp > 1 || this.and(knownAngle >= 90, partialSide >= knownSide))
                throw status + "No solution";
            else */if (temp == 1 || knownSide >= partialSide) {
                status += "Unique solution";
                partialAngle = this.radToDeg(Math.asin(temp));
                unknownAngle = 180 - knownAngle - partialAngle;
                unknownSide = ratio * Math.sin(this.degToRad(unknownAngle));  // Law of sines
                area = knownSide * partialSide * Math.sin(this.degToRad(unknownAngle)) / 2;
            } else {
                status += "Two solutions";
                var partialAngle0 = this.radToDeg(Math.asin(temp));
                var partialAngle1 = 180 - partialAngle0;
                var unknownAngle0 = 180 - knownAngle - partialAngle0;
                var unknownAngle1 = 180 - knownAngle - partialAngle1;
                var unknownSide0 = ratio * Math.sin(this.degToRad(unknownAngle0));  // Law of sines
                var unknownSide1 = ratio * Math.sin(this.degToRad(unknownAngle1));  // Law of sines
                partialAngle = [partialAngle0, partialAngle1];
                unknownAngle = [unknownAngle0, unknownAngle1];
                unknownSide = [unknownSide0, unknownSide1];
                area = [knownSide * partialSide * Math.sin(this.degToRad(unknownAngle0)) / 2,
                        knownSide * partialSide * Math.sin(this.degToRad(unknownAngle1)) / 2];
            }
            if (this.and(a != null, A == null)) A = partialAngle;
            if (this.and(b != null, B == null)) B = partialAngle;
            if (this.and(c != null, C == null)) C = partialAngle;
            if (this.and(a == null, A == null)) { a = unknownSide; A = unknownAngle; }
            if (this.and(b == null, B == null)) { b = unknownSide; B = unknownAngle; }
            if (this.and(c == null, C == null)) { c = unknownSide; C = unknownAngle; }
        }
        
        //return [a, b, c, A, B, C, area, status];
        return [ A, B, C];
    }

    returnArrayPoly(ar)
    {
        var ar2 = [];
        for(var i = 0; i < ar.length; i++)
        {
            ar2.push(ar[i].x);
            ar2.push(ar[i].y);
        }
        return ar2;
    }

    returnArrayPolyPointsInsets(ar)
    {
        var AR = [];
        for(var i = 0; i < ar.length; i++)
        {
            var j = (i === ar.length - 1) ? 0 : i+1;
            AR[i] = [ar[i]['x'],ar[i]['y'],ar[j]['x'],ar[j]['y']];
        }

        return AR;
    }

    returnArrayPolyPoints(ar)
    {
        var ar2 = [];
        for(var i = 0; i < ar.length; i++)
        {
            ar2[i] = [];
            for(var j = 0; j < ar[i].length; j++)
            {
                if(j === 0)
                {
                    ar2[i].push(ar[i][0].x);
                    ar2[i].push(ar[i][0].y);
                }
            }
        }
        return ar2;
    }

    getWedgeRadius(deg2,v)
    {
        var deg = (deg2 < 180) ? deg2 : 360 - deg2;
        var h = (v/100) * 20;
        var rest = v - h;
        var d = (180 - deg) / 1.8;
        return h + (rest * (d/100));
    }

    formatNumber(x)
    {
        return x.toPrecision(9);
    }
    
    degToRad(x)
    {
        return x / 180 * Math.PI;
    }
    
    radToDeg(x)
    {
        return x / Math.PI * 180;
    }
    
    // Workaround to avoid HTML parsing issues
    and(x, y)
    {
        return x ? y : false;
    }

    angleInDegrees(ini, end)
    {
        var radian = Math.atan2((end.y - ini.y), (end.x - ini.x));
        return this.mod(radian * 180 / Math.PI + 90, 360);
    }

    mod(a, b)
    {
        return a - Math.floor (a / b) * b;
    }
}